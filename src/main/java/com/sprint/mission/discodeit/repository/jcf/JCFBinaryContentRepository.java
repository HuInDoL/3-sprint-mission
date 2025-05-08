package com.sprint.mission.discodeit.repository.jcf;

import com.sprint.mission.discodeit.entity.BinaryContent;
import com.sprint.mission.discodeit.repository.BinaryContentRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@ConditionalOnProperty(name = "discodeit.repository.type", havingValue = "jcf", matchIfMissing = true)
@Repository
public class JCFBinaryContentRepository implements BinaryContentRepository {

    Map<UUID, BinaryContent> binaryContentMap;

    public JCFBinaryContentRepository() {
        this.binaryContentMap = new HashMap<>();
    }

    @Override
    public BinaryContent save(BinaryContent binaryContent) {
        // 1. BinaryContent를 Map에 저장
        binaryContentMap.put(binaryContent.getId(), binaryContent);
        return binaryContent;
    }

    @Override
    public BinaryContent findById(UUID id) {
        return binaryContentMap.get(id);
    }

    @Override
    public List<BinaryContent> findAllByIdIn(List<UUID> ids) {
        return ids.stream() // ids 리스트에 대해 Stream 생성
                .map(binaryContentMap::get) // 각 UUID에 대해 binaryContentMap에서 해당하는 BinaryContent 가져옴
                .filter(Objects::nonNull) // null 아닌 값만 filter
                .collect(Collectors.toList()); // 리스트로 collect
    }

    @Override
    public List<BinaryContent> findAll() {
        return new ArrayList<>(binaryContentMap.values());
    }

    @Override
    public boolean existsById(UUID id) {
        return binaryContentMap.containsKey(id);
    }

    @Override
    public void delete(UUID id) {
        binaryContentMap.remove(id);
    }
}
