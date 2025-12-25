package com.lingosphinx.media.repository;

import com.lingosphinx.media.domain.PromptTemplate;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PromptTemplateRepository extends JpaRepository<PromptTemplate, Long> {
    @EntityGraph(attributePaths = {"translations"})
    @Override
    Optional<PromptTemplate> findById(Long id);
}
