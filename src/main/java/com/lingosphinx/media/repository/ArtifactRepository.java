package com.lingosphinx.media.repository;

import com.lingosphinx.media.domain.Artifact;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtifactRepository extends JpaRepository<Artifact, Long> {
    @EntityGraph(attributePaths = {"translations"})
    @Override
    Optional<Artifact> findById(Long id);
}
