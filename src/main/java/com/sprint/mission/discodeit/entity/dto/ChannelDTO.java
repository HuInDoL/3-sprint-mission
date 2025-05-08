package com.sprint.mission.discodeit.entity.dto;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.ChannelType;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public record ChannelDTO(
        UUID id,
        ChannelType type,
        String name,
        String description,
        Instant lastReadAt,
        List<UUID> participantIds
) { }
