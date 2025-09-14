package com.lingosphinx.media.service;

import com.lingosphinx.media.dto.ArtifactImportDto;
import com.lingosphinx.media.exception.ResourceNotFoundException;
import com.lingosphinx.media.mapper.ArtifactImportMapper;
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
public class ArtifactImportServiceImpl implements ArtifactImportService {

    private final ArtifactRepository artifactRepository;
    private final ArtifactImportMapper artifactImportMapper;
    private final AccountService accountService;

    @Override
    public ArtifactImportDto create(ArtifactImportDto artifactImportDto) {
        var artifactImport = artifactImportMapper.toEntity(artifactImportDto);
        var account = accountService.registerCurrent();
        var savedArtifacts = artifactRepository.saveAll(artifactImport.getArtifacts().stream().peek(artifact -> {
            artifact.setOwner(account);
        }).toList());
        artifactImport.setArtifacts(savedArtifacts);
        log.info("ArtifactImport successful");
        return artifactImportMapper.toDto(artifactImport);
    }

}