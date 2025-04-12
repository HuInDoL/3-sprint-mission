package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.UserService;
import com.sprint.mission.discodeit.service.jcf.JCFChannelService;
import com.sprint.mission.discodeit.service.jcf.JCFMessageService;
import com.sprint.mission.discodeit.service.jcf.JCFUserService;

import java.util.UUID;

public class JavaApplication {
    public static void main(String[] args) {
        // 서비스 생성
        UserService userService = new JCFUserService();
        ChannelService channelService = new JCFChannelService();
        MessageService messageService = new JCFMessageService();

        // User 등록
        User user = new User("Alice", 20, "alice@gmail.com");
        userService.createUser(user);

        // Channel 등록
        Channel channel = new Channel("general", user);
        channelService.createChannel(channel);

        // Message 등록
        Message message = new Message(user.getId(), channel.getId(), "Hello, world!");
        messageService.createMessage(message);

        // 조회
        System.out.println("User 조회: " + userService.readUser(user.getId()));
        System.out.println("Channel 조회: " + channelService.readChannel(channel.getId()));
        System.out.println("Message 조회: " + messageService.readMessage(message.getId()));

        // 수정
        userService.updateUser(user.getId(), "Bob");
        channelService.updateChannel(channel.getId(), "random");
        messageService.updateMessage(message.getId(), "Updated message");

        // 수정된 데이터 확인
        System.out.println("수정된 User: " + userService.readUser(user.getId()));
        System.out.println("수정된 Channel: " + channelService.readChannel(channel.getId()));
        System.out.println("수정된 Message: " + messageService.readMessage(message.getId()));

        // 삭제
        userService.deleteUser(user.getId());
        channelService.deleteChannel(channel.getId());
        messageService.deleteMessage(message.getId());

        // 삭제된 데이터 조회 시도
        System.out.println("삭제 후 User: " + userService.readUser(user.getId()));
        System.out.println("삭제 후 Channel: " + channelService.readChannel(channel.getId()));
        System.out.println("삭제 후 Message: " + messageService.readMessage(message.getId()));

        // 전체 조회
        System.out.println("전체 Users: " + userService.readAllUsers());
        System.out.println("전체 Channels: " + channelService.readAllChannels());
        System.out.println("전체 Messages: " + messageService.readAllMessages());
    }
}
