package com.sprint.mission.discodeit.entity;

import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Getter
public class UserStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID id;
    private Instant createdAt;
    private Instant updatedAt;
    //
    private UUID userId;
    private Instant lastActiveAt;

    public UserStatus(User user) {

        this.id = UUID.randomUUID();
//        this.createdAt = Instant.ofEpochSecond(Instant.now().getEpochSecond());
        this.createdAt = Instant.now().truncatedTo(ChronoUnit.SECONDS);
        this.updatedAt = this.createdAt;
        //
        this.userId = user.getId();

        this.lastActiveAt = this.createdAt;

    }

    public boolean isOnline() {
//        Instant instantFiveMinutesAgo = Instant.now().minus(Duration.ofMinutes(5));
//        return lastLoginAt.isAfter((instantFiveMinutesAgo));
        return lastActiveAt.plusSeconds(300).isAfter(Instant.now()); // true: 로그인
    }

    public void update() {
        boolean anyValueUpdated = false;
        if (this.isOnline()) {
            this.lastActiveAt = Instant.now().truncatedTo(ChronoUnit.SECONDS);
            anyValueUpdated = true;
        }

        if (anyValueUpdated) {
            this.updatedAt = Instant.ofEpochSecond(Instant.now().getEpochSecond());
        }
    }
}
