package com.sprint.mission.discodeit.entity.service.jcf;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.entity.service.UserService;

import java.util.*;

public class JCFUserService implements UserService { // 왜 abstract를 해야만 하는가?
    private final HashMap<UUID, User> data;


    public JCFUserService() {
        this.data = new HashMap<>(); // HashMap이 UUID로 검색 용이
    }

    @Override
    public void createUser(User user) {
        // 이름이 같으면 이메일도 비교해서, 둘 중 하나라도 다르면 추가?
        data.put(user.getId(), user);
    }

    @Override
    public User readUser(UUID id) {
        return data.get(id);
    }

    @Override
    public List<User> readAllUsers() {
        return new ArrayList<>(data.values());
    };

    @Override
    public void updateUser(User user) {
        data.put(user.getId(), user);
    };

    @Override
    public void deleteUser(UUID id) {
        data.remove(id);
    };
}
