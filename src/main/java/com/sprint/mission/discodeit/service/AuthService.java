package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.dto.request.LoginRequest;
import com.sprint.mission.discodeit.dto.data.UserDto;

public interface AuthService {

    UserDto login(LoginRequest loginRequest);
}
