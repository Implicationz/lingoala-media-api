package com.lingosphinx.media.controller;


import com.lingosphinx.media.domain.ArtifactImport;
import com.lingosphinx.media.dto.ArtifactDto;
import com.lingosphinx.media.dto.ArtifactImportDto;
import com.lingosphinx.media.service.ArtifactImportService;
import com.lingosphinx.media.service.ArtifactService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artifact-import")
@RequiredArgsConstructor
@Tag(name = "ArtifactImport API")
public class ArtifactImportController {

    private final ArtifactImportService artifactImportService;

    @PostMapping
    public ResponseEntity<ArtifactImportDto> create(@RequestBody @Valid ArtifactImportDto artifactImport) {
        return ResponseEntity.status(HttpStatus.CREATED).body(artifactImportService.create(artifactImport));
    }
}