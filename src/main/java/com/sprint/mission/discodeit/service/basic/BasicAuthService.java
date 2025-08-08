package com.sprint.mission.discodeit.service.basic;

import com.sprint.mission.discodeit.dto.data.UserDto;
import com.sprint.mission.discodeit.dto.request.user.RoleUpdateRequest;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.exception.user.UserNotFoundException;
import com.sprint.mission.discodeit.mapper.UserMapper;
import com.sprint.mission.discodeit.repository.UserRepository;
import com.sprint.mission.discodeit.service.AuthService;
import com.sprint.mission.discodeit.service.DiscodeitUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class BasicAuthService implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final SessionRegistry sessionRegistry;

    private static final String SERVICE_NAME = "[AuthService] ";

    @Override
    @Transactional
    public UserDto getCurrentUserInfo(DiscodeitUserDetails userDetails) {

        log.debug(SERVICE_NAME + "현재 사용자 정보 조회 요청");

        String username = userDetails.getUsername();
        log.debug(SERVICE_NAME + "조회할 사용자명: {}", username);

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username));

        UserDto userDto = userMapper.toDto(user);
        log.debug(SERVICE_NAME + "DTO 변환 완료: {}", userDto);

        return userDto;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public UserDto updateRole(RoleUpdateRequest request) {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new UserNotFoundException("사용자가 존재하지 않습니다."));

        user.updateRole(request.newRole());
        invalidateUserSessionsByUsername(user.getUsername());
        User updatedUser = userRepository.save(user);

        log.info(SERVICE_NAME + "사용자 권한 변경 및 세션 무효화 완료 ");

        return userMapper.toDto(updatedUser);
    }

    private void invalidateUserSessionsByUsername(String username) {
        try {
            int expiredCount = 0;

            for (Object principal : sessionRegistry.getAllPrincipals()) {
                DiscodeitUserDetails userDetails = (DiscodeitUserDetails) principal;
                String principalUsername = userDetails.getUsername();

                if (principalUsername.equals(username)) {
                    var sessions = sessionRegistry.getAllSessions(principal, false);
                    if (!sessions.isEmpty()) {
                        sessions.forEach(SessionInformation::expireNow);
                        expiredCount += sessions.size();
                    }
                }
            }

            log.info(SERVICE_NAME + "사용자 '{}'의 만료된 세션 수: {}", username, expiredCount);
        } catch (Exception e) {
            log.error(SERVICE_NAME + "사용자 '{}'의 세션 무효화 중 오류: {}", username, e.getMessage(), e);
        }
    }
}
