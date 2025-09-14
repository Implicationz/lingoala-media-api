package com.lingosphinx.media.service;

import com.lingosphinx.media.dto.ArtifactImportDto;
import jakarta.validation.Valid;

import java.util.List;

public interface ArtifactImportService {
    ArtifactImportDto create(ArtifactImportDto artifactImport);
}
