package com.sprint.mission.discodeit.entity.service;

import com.sprint.mission.discodeit.entity.Channel;

import java.util.List;
import java.util.UUID;

public interface ChannelService {
    void createChannel(Channel channel);
    Channel readChannel();
    List<Channel> readAllChannels();
    void updateChannel(Channel channel);
    void deleteChannel(UUID id);
}
