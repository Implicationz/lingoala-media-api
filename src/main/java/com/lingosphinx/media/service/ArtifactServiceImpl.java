package com.lingosphinx.media.service;

import com.lingosphinx.media.domain.ArtifactAsset;
import com.lingosphinx.media.domain.ArtifactTranslation;
import com.lingosphinx.media.dto.ArtifactAssetDto;
import com.lingosphinx.media.dto.ArtifactDto;
import com.lingosphinx.media.dto.ArtifactTranslationDto;
import com.lingosphinx.media.exception.ResourceNotFoundException;
import com.lingosphinx.media.mapper.ArtifactMapper;
import com.lingosphinx.media.repository.ArtifactRepository;
import com.lingosphinx.media.utility.EntitySyncUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ArtifactServiceImpl implements ArtifactService {

    private final ArtifactRepository artifactRepository;
    private final ArtifactMapper artifactMapper;
    private final AccountService accountService;

    @Override
    public ArtifactDto create(ArtifactDto artifactDto) {
        var artifact = artifactMapper.toEntity(artifactDto);
        var savedArtifact = artifactRepository.save(artifact);
        log.info("Artifact created with id: {}", savedArtifact.getId());
        return artifactMapper.toDto(savedArtifact);
    }

    @Override
    public ArtifactDto createForCurrentAccount(ArtifactDto artifactDto) {
        var artifact = artifactMapper.toEntity(artifactDto);
        var account = accountService.registerCurrent();
        artifact.setOwner(account);
        var savedArtifact = artifactRepository.save(artifact);
        log.info("Artifact created with id: {}", savedArtifact.getId());
        return artifactMapper.toDto(savedArtifact);
    }


    @Override
    @Transactional(readOnly = true)
    public ArtifactDto readById(Long id) {
        var artifact = artifactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artifact not found"));
        log.info("Artifact found with id: {}", id);
        return artifactMapper.toDto(artifact);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ArtifactDto> readAll() {
        log.info("Reading all artifacts");
        return artifactRepository.findAll().stream()
                .map(artifactMapper::toDto)
                .toList();
    }

    @Override
    public ArtifactDto update(Long id, ArtifactDto artifactDto) {
        var existingArtifact = artifactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artifact not found"));
        artifactMapper.updateEntityFromDto(artifactDto, existingArtifact);
        EntitySyncUtils.syncChildEntities(existingArtifact.getTranslations(), artifactDto.getTranslations(),
                ArtifactTranslation::getId,
                ArtifactTranslationDto::getId,
                artifactMapper::toEntity,
                artifactTranslation -> artifactTranslation.setArtifact(existingArtifact),
                artifactMapper::updateEntityFromDto
                );
        EntitySyncUtils.syncChildEntities(existingArtifact.getAssets(), artifactDto.getAssets(),
                ArtifactAsset::getId,
                ArtifactAssetDto::getId,
                artifactMapper::toEntity,
                artifactAsset -> artifactAsset.setArtifact(existingArtifact),
                artifactMapper::updateEntityFromDto
        );
        artifactRepository.flush();
        log.info("Artifact updated with id: {}", id);
        return artifactMapper.toDto(existingArtifact);
    }

    @Override
    public void delete(Long id) {
        artifactRepository.deleteById(id);
        log.info("Artifact deleted with id: {}", id);
    }
}