package com.sprint.mission.discodeit.service.basic;

import com.sprint.mission.discodeit.dto.data.UserDto;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.mapper.UserMapper;
import com.sprint.mission.discodeit.repository.UserRepository;
import com.sprint.mission.discodeit.service.AuthService;
import com.sprint.mission.discodeit.service.DiscodeitUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class BasicAuthService implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private static final String SERVICE_NAME = "[AuthService] ";

    @Override
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
}
