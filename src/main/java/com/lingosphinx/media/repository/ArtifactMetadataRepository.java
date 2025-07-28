package com.lingosphinx.media.repository;

import com.lingosphinx.media.domain.ArtifactMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtifactMetadataRepository extends JpaRepository<ArtifactMetadata, Long> {
    Optional<ArtifactMetadata> findByArtifact_Id(Long artifactId);
}