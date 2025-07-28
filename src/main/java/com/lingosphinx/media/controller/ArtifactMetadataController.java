package com.lingosphinx.media.controller;


import com.lingosphinx.media.dto.ArtifactMetadataDto;
import com.lingosphinx.media.service.ArtifactMetadataService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artifact-metadata")
@RequiredArgsConstructor
@Tag(name = "ArtifactMetadata API")
public class ArtifactMetadataController {

    private final ArtifactMetadataService artifactMetadataService;

    @PostMapping
    public ResponseEntity<ArtifactMetadataDto> create(@RequestBody @Valid ArtifactMetadataDto artifactMetadata) {
        return ResponseEntity.status(HttpStatus.CREATED).body(artifactMetadataService.create(artifactMetadata));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtifactMetadataDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(artifactMetadataService.readById(id));
    }

    @GetMapping(params = "artifactId")
    public ResponseEntity<ArtifactMetadataDto> readByArtifactId(@RequestParam Long artifactId) {
        return ResponseEntity.ok(artifactMetadataService.readByArtifactId(artifactId));
    }

    @GetMapping
    public ResponseEntity<List<ArtifactMetadataDto>> readAll() {
        return ResponseEntity.ok(artifactMetadataService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtifactMetadataDto> update(@PathVariable Long id, @RequestBody @Valid ArtifactMetadataDto artifactMetadata) {
        return ResponseEntity.ok(artifactMetadataService.update(id, artifactMetadata));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        artifactMetadataService.delete(id);
        return ResponseEntity.noContent().build();
    }
}