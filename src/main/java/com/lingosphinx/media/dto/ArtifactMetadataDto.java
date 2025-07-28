package com.lingosphinx.media.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtifactMetadataDto {
    private Long id;
    private ArtifactDto artifact;
    private Map<String, String> attributes;
}