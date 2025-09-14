package com.lingosphinx.media.repository;

import com.lingosphinx.media.domain.ArtifactInstance;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtifactInstanceRepository extends JpaRepository<ArtifactInstance, Long> {
    @Override
    Optional<ArtifactInstance> findById(Long id);

    @EntityGraph(attributePaths = {"artifact", "artifact.translations", "account"})
    Optional<ArtifactInstance> findByArtifactIdAndAccountId(Long artifactId, Long accountId);
}
