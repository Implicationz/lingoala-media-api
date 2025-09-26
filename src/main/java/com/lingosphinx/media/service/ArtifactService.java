package com.lingosphinx.media.service;

import com.lingosphinx.media.dto.ArtifactDto;

import java.util.List;

public interface ArtifactService {
    ArtifactDto create(ArtifactDto artifact);

    ArtifactDto createForCurrentAccount(ArtifactDto artifactDto);

    ArtifactDto readById(Long id);
    List<ArtifactDto> readAll();
    ArtifactDto update(Long id, ArtifactDto artifact);
    void delete(Long id);
}
