package com.lingosphinx.media.service;

import com.lingosphinx.media.dto.ArtifactInstanceDto;
import com.lingosphinx.media.exception.ResourceNotFoundException;
import com.lingosphinx.media.mapper.ArtifactInstanceMapper;
import com.lingosphinx.media.repository.ArtifactInstanceRepository;
import com.lingosphinx.media.repository.ArtifactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ArtifactInstanceServiceImpl implements ArtifactInstanceService {

    private final ArtifactRepository artifactRepository;
    private final ArtifactInstanceRepository artifactInstanceRepository;
    private final ArtifactInstanceMapper artifactInstanceMapper;
    private final AccountService accountService;

    @Override
    public ArtifactInstanceDto create(ArtifactInstanceDto artifactInstanceDto) {
        var artifactInstance = artifactInstanceMapper.toEntity(artifactInstanceDto);
        var savedArtifactInstance = artifactInstanceRepository.save(artifactInstance);
        log.info("ArtifactInstance created with id: {}", savedArtifactInstance.getId());
        return artifactInstanceMapper.toDto(savedArtifactInstance);
    }

    @Override
    public ArtifactInstanceDto activate(ArtifactInstanceDto artifactInstanceDto) {
        var account = accountService.registerCurrent();
        var artifactId = artifactInstanceDto.getArtifact().getId();
        var accountId = account.getId();

        var instance = artifactInstanceRepository
                .findByArtifactIdAndAccountId(artifactId, accountId)
                .orElseGet(() -> {
                    var artifact = artifactRepository.findById(artifactId)
                            .orElseThrow(() -> new ResourceNotFoundException("Artifact not found"));
                    var newInstance = artifactInstanceMapper.toEntity(artifactInstanceDto);
                    newInstance.setArtifact(artifact);
                    newInstance.setAccount(account);
                    return artifactInstanceRepository.save(newInstance);
                });

        log.info("ArtifactInstance activated for Artifact {} and Account {}", artifactId, accountId);
        return artifactInstanceMapper.toDto(instance);
    }

    @Override
    @Transactional(readOnly = true)
    public ArtifactInstanceDto readById(Long id) {
        var artifactInstance = artifactInstanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ArtifactInstance not found"));
        log.info("ArtifactInstance found with id: {}", id);
        return artifactInstanceMapper.toDto(artifactInstance);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ArtifactInstanceDto> readAll() {
        log.info("Reading all artifactInstances");
        return artifactInstanceRepository.findAll().stream()
                .map(artifactInstanceMapper::toDto)
                .toList();
    }

    @Override
    public ArtifactInstanceDto update(Long id, ArtifactInstanceDto artifactInstanceDto) {
        var existingArtifactInstance = artifactInstanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ArtifactInstance not found"));
        log.info("ArtifactInstance updated with id: {}", id);
        artifactInstanceMapper.updateEntityFromDto(artifactInstanceDto, existingArtifactInstance);
        return artifactInstanceMapper.toDto(existingArtifactInstance);
    }

    @Override
    public void delete(Long id) {
        artifactInstanceRepository.deleteById(id);
        log.info("ArtifactInstance deleted with id: {}", id);
    }
}