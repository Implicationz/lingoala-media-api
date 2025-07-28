package com.lingosphinx.media.controller;


import com.lingosphinx.media.dto.ArtifactDto;
import com.lingosphinx.media.service.ArtifactService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artifact")
@RequiredArgsConstructor
@Tag(name = "Artifact API")
public class ArtifactController {

    private final ArtifactService artifactService;

    @PostMapping
    public ResponseEntity<ArtifactDto> create(@RequestBody @Valid ArtifactDto artifact) {
        return ResponseEntity.status(HttpStatus.CREATED).body(artifactService.create(artifact));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtifactDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(artifactService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<ArtifactDto>> readAll() {
        return ResponseEntity.ok(artifactService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtifactDto> update(@PathVariable Long id, @RequestBody @Valid ArtifactDto artifact) {
        return ResponseEntity.ok(artifactService.update(id, artifact));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        artifactService.delete(id);
        return ResponseEntity.noContent().build();
    }
}