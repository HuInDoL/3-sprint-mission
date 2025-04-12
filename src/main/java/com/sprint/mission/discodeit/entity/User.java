package com.sprint.mission.discodeit.entity;

import com.sprint.mission.discodeit.entity.Base;
import java.util.UUID;

public class User {
    private UUID id;
    private int age;
    private String name;
    private String email;
    // @CreatedDate 는 Spring 전용
    private long createdAt;
    // @CreatedDate
    private long updatedAt;

    public User() {
    }

    public User(UUID id, int age, String name, String email, long createdAt, long updatedAt) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getter Methods
    public UUID getId() { return id; }

    public int getAge() { return age; }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public long getCreatedAt() { return createdAt; }

    public long getUpdatedAt() { return updatedAt; }


    // Setter Methods
    public void setId(UUID id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
