package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.service.MessageService;

import java.util.*;
import java.util.stream.Collectors;

public class JCFMessageService implements MessageService {

    // List 계열 좋음, 그럼 일방향 리스트? 일방적으로 조회 삽입 다수, 삭제는 거의 없음, 조회 많으면 index, -> ArrayList
    private final Map<UUID, Message> data;

    public JCFMessageService() { this.data = new HashMap<>(); }

    @Override
    public void createMessage(Message message) {
        // 조건문으로 message를 받게 해야 하나? 그냥 보내면 받아야 하잖아
        this.data.put(message.getId(), message);
    }

    @Override
    public Message readMessage(UUID id) { // Q1. 왜 abstract 선언해야해? String content를 불러와야 하나?
        for (Message msg : data) {
            if (msg.getId().equals(id)) {
                return msg;
            }
        }
        return null;
    }

    @Override
    public List<Message> readMessagesByChannel(UUID channelId) {
        return data.values().stream()
                .filter(message -> message.getChannel().getId().equals(channelId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Message> readAllMessages() {
        return this.data;
    }

    @Override
    public Message updateMessage(UUID id, String newMessage) {
        Message message = data.get(id);

        if (message == null) {
            System.out.println("해당 ID를 가진 메시지를 찾을 수 없습니다.");
            return null;
        }

        if (newMessage != null && !newMessage.isEmpty()) {
            message.updateMessage(newMessage);
            data.put(id, message); // 덮어쓰기
            System.out.println("메시지가 성공적으로 수정되었습니다.");
        } else {
            System.out.println("새 메시지 내용이 유효하지 않습니다.");
        }

        return message;
    }

    @Override
    public void deleteMessage(UUID id) {
        this.data.remove(id);
    }
}
