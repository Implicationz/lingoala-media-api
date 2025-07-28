package com.lingosphinx.media.service;

import com.lingosphinx.media.dto.ArtifactMetadataDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArtifactMetadataService {
    ArtifactMetadataDto create(ArtifactMetadataDto artifactMetadata);
    ArtifactMetadataDto readById(Long id);

    @Transactional(readOnly = true)
    ArtifactMetadataDto readByArtifactId(Long artifactId);

    List<ArtifactMetadataDto> readAll();
    ArtifactMetadataDto update(Long id, ArtifactMetadataDto artifactMetadata);
    void delete(Long id);
}
