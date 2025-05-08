package com.sprint.mission.discodeit.entity.dto;

import com.sprint.mission.discodeit.entity.FileType;

import java.util.UUID;

public record CreateBinaryContentRequest (
        String fileName,
        FileType fileType,
        byte[] content
) { }
