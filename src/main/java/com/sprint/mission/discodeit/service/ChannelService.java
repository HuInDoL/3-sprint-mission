package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.Channel;

import java.util.List;
import java.util.UUID;

public interface ChannelService {
    Channel createChannel(String channelName, String description); // C
    Channel readChannel(UUID id); // R
    List<Channel> readAllChannels();
    Channel updateChannel(UUID id, String newName, String newDescription); // U
    void deleteChannel(UUID id); // D
}
