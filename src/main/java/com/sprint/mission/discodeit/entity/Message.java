package com.sprint.mission.discodeit.entity;


import java.util.UUID;

public class Message extends Base {
    private User user;
    private Channel channel; // 이걸 Channel 클래스와 어떻게 연결시키지
    private String message; // message는 결국 HashSet이야

    public Message(User user, Channel channel, String message) {
        super();
        this.user = user;
        this.channel = channel;
        this.message = message;
    }


    // Getter Methods

    public User getUser() { return user; }

    public Channel getChannel() { return channel; }

    public String getContent() {
        return message;
    }


    // Update Method

    public void updateUser(UUID id) {
        this.user = super.getId();
        super.updateUpdatedAt();
    }

    public void updateChannel(Channel channel) {
        this.channel = channel;
        super.updateUpdatedAt();
    }

    public void updateMessage(String message) {
        this.message = message;
        super.updateUpdatedAt();
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + getContent() + '\'' +
                ", user='" + getUser().getName() + '\'' +
                ", channel='" + getChannel().getChannelName() + '\'' +
                ", id='" + getId() + '\'' +
                ", createdAt='" + getCreatedAt() + '\'' +
                ", updatedAt='" + getUpdatedAt() + '\'' +
                '}';
}
