package com.lingosphinx.media.domain;

import com.lingosphinx.media.dto.ArtifactDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtifactImport {

    private List<Artifact> artifacts;
}