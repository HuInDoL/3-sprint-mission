package com.sprint.mission.discodeit.entity.service;


import com.sprint.mission.discodeit.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    void createUser(User user);
    User readUser(UUID id);
    List<User> readAllUsers();
    void updateUser(User user);
    void deleteUser(UUID id);
}
