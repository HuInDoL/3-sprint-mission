package com.sprint.mission.discodeit.entity.service;

import com.sprint.mission.discodeit.entity.Message;

import java.util.List;
import java.util.UUID;

public interface MessageService {
    void createMessage(Message message);
    Message readMessage(UUID id);
    List<Message> readAllMessages();
    void updateMessage(Message message, Message updatedMessage);
    void deleteMessage(UUID id);
}
