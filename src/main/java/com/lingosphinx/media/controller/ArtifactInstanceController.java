package com.lingosphinx.media.controller;


import com.lingosphinx.media.dto.ArtifactInstanceDto;
import com.lingosphinx.media.service.ArtifactInstanceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artifact-instance")
@RequiredArgsConstructor
@Tag(name = "ArtifactInstance API")
public class ArtifactInstanceController {

    private final ArtifactInstanceService artifactInstanceService;

    @PostMapping
    public ResponseEntity<ArtifactInstanceDto> create(@RequestBody @Valid ArtifactInstanceDto artifactInstance) {
        return ResponseEntity.status(HttpStatus.CREATED).body(artifactInstanceService.create(artifactInstance));
    }

    @PostMapping("/activation")
    public ResponseEntity<ArtifactInstanceDto> activate(@RequestBody @Valid ArtifactInstanceDto artifactInstance) {
        return ResponseEntity.status(HttpStatus.CREATED).body(artifactInstanceService.activate(artifactInstance));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtifactInstanceDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(artifactInstanceService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<ArtifactInstanceDto>> readAll() {
        return ResponseEntity.ok(artifactInstanceService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtifactInstanceDto> update(@PathVariable Long id, @RequestBody @Valid ArtifactInstanceDto artifactInstance) {
        return ResponseEntity.ok(artifactInstanceService.update(id, artifactInstance));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        artifactInstanceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}