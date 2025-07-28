package com.lingosphinx.media.service;

import com.lingosphinx.media.dto.ArtifactMetadataDto;
import com.lingosphinx.media.exception.ResourceNotFoundException;
import com.lingosphinx.media.mapper.ArtifactMetadataMapper;
import com.lingosphinx.media.repository.ArtifactMetadataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ArtifactMetadataServiceImpl implements ArtifactMetadataService {

    private final ArtifactMetadataRepository artifactMetadataRepository;
    private final ArtifactMetadataMapper artifactMetadataMapper;

    @Override
    public ArtifactMetadataDto create(ArtifactMetadataDto artifactMetadataDto) {
        var artifactMetadata = artifactMetadataMapper.toEntity(artifactMetadataDto);
        var savedArtifactMetadata = artifactMetadataRepository.save(artifactMetadata);
        log.info("ArtifactMetadata created with id: {}", savedArtifactMetadata.getId());
        return artifactMetadataMapper.toDto(savedArtifactMetadata);
    }

    @Override
    @Transactional(readOnly = true)
    public ArtifactMetadataDto readById(Long id) {
        var artifactMetadata = artifactMetadataRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ArtifactMetadata not found"));
        log.info("ArtifactMetadata found with id: {}", id);
        return artifactMetadataMapper.toDto(artifactMetadata);
    }

    @Transactional(readOnly = true)
    @Override
    public ArtifactMetadataDto readByArtifactId(Long artifactId) {
        var artifactMetadata = artifactMetadataRepository.findByArtifact_Id(artifactId)
                .orElseThrow(() -> new ResourceNotFoundException("ArtifactMetadata not found for artifactId: " + artifactId));
        log.info("ArtifactMetadata found with artifactId: {}", artifactId);
        return artifactMetadataMapper.toDto(artifactMetadata);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ArtifactMetadataDto> readAll() {
        log.info("Reading all artifactMetadatas");
        return artifactMetadataRepository.findAll().stream()
                .map(artifactMetadataMapper::toDto)
                .toList();
    }

    @Override
    public ArtifactMetadataDto update(Long id, ArtifactMetadataDto artifactMetadataDto) {
        var existingArtifactMetadata = artifactMetadataRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ArtifactMetadata not found"));
        artifactMetadataMapper.updateEntityFromDto(artifactMetadataDto, existingArtifactMetadata);
        artifactMetadataRepository.flush();
        log.info("ArtifactMetadata updated with id: {}", id);
        return artifactMetadataMapper.toDto(existingArtifactMetadata);
    }

    @Override
    public void delete(Long id) {
        artifactMetadataRepository.deleteById(id);
        log.info("ArtifactMetadata deleted with id: {}", id);
    }
}