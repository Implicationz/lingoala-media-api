package com.lingosphinx.media.service;

import com.lingosphinx.media.dto.ArtifactInstanceDto;
import jakarta.validation.Valid;

import java.util.List;

public interface ArtifactInstanceService {
    ArtifactInstanceDto create(ArtifactInstanceDto artifactInstance);
    ArtifactInstanceDto activate(@Valid ArtifactInstanceDto artifactInstance);
    ArtifactInstanceDto readById(Long id);
    List<ArtifactInstanceDto> readAll();
    ArtifactInstanceDto update(Long id, ArtifactInstanceDto artifactInstance);
    void delete(Long id);
}
