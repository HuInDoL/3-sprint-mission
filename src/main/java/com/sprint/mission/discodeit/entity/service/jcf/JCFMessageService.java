package com.sprint.mission.discodeit.entity.service.jcf;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.service.MessageService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JCFMessageService implements MessageService {

    // List 계열 좋음, 그럼 일방향 리스트? 일방적으로 조회 삽입 다수, 삭제는 거의 없음, 조회 많으면 index, -> ArrayList
    private final List<Message> data = new ArrayList<>();

    public JCFMessageService() {}

    @Override
    public void createMessage(Message message) {
        // 조건문으로 message를 받게 해야 하나? 그냥 보내면 받아야 하잖아
        this.data.add(message);
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
    // 25-04-10 21:00 까지

    @Override
    public List<Message> readAllMessages() {
        return this.data;
    }

    @Override
    public void updateMessage(Message message, Message updatedMessage) {
        int index = data.indexOf(message);
        if (index != -1) {
            data.set(index, updatedMessage);
        }
//        if (!this.data.contains(message)) {
//            System.out.println("There's no such message");
//        } else {
//            // 여기에 기존 메시지가 있던 인덱스를 updatedMessage로 바꿔야함
//        }
    }

    @Override
    public void deleteMessage(UUID id) {
        this.data.remove(id);
    }
}
