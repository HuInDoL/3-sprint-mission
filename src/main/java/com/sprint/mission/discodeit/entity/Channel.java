package com.sprint.mission.discodeit.entity;

import java.util.UUID;

public class Channel {
    private UUID id;
    private int age;
    private String name;
    private String email;
    private long createdAt;
    private long updatedAt;

    public Channel() {
    }

    public Channel(UUID id, int age, String name, String email, long createdAt, long updatedAt) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Update Method
    public void update(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter Methods
    public UUID getId() {
        return id;
    }

    // Setter Methods
    public void setId(UUID id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}