package com.sprint.mission.discodeit.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Message {
    private UUID id;
    private int age;
    private String name;
    private String email;
    private String content;
    private LocalDateTime sentAt;
    private long createdAt;
    private long updatedAt;

    public Message() {
    }

    public Message(UUID id, int age, String name, String email, long createdAt, long updatedAt) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
        this.content = "";
        this.sentAt = LocalDateTime.now();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getter Methods
    public UUID getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }


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

    public void setContent(String content) {
        this.content = content;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

}
