package com.sprint.mission.discodeit.controller.api;

import com.sprint.mission.discodeit.dto.data.BinaryContentDto;
import com.sprint.mission.discodeit.entity.BinaryContent;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "BinaryContent", description = "첨부 파일 API")
public interface BinaryContentApi {

    @Operation(summary = "첨부 파일 조회")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "첨부 파일 조회 성공",
            content = @Content(schema = @Schema(implementation = BinaryContent.class))),
        @ApiResponse(responseCode = "404", description = "첨부 파일을 찾을 수 없음",
            content = @Content(examples = @ExampleObject(value = "BinaryContent with id {binaryContentId} not found")))
    })
    ResponseEntity<BinaryContentDto> find(
        @Parameter(description = "조회할 첨부 파일 ID") UUID binaryContentId);

    @Operation(summary = "여러 첨부 파일 조회")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "첨부 파일 목록 조회 성공")
    })
    @GetMapping
    ResponseEntity<List<BinaryContent>> findAllByIdIn(
        @Parameter(description = "조회할 첨부 파일 ID 목록")
        @RequestParam List<UUID> binaryContentIds
    );

    @Operation(summary = "파일 다운로드")
    @ApiResponse(responseCode = "200", description = "성공적으로 파일 다운로드",
        content = @Content(schema = @Schema(implementation = Resource.class)))
    ResponseEntity<?> download(
        @Parameter(description = "다운로드할 파일 ID") UUID binaryContentId
    );
}

