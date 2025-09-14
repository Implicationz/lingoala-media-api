package com.lingosphinx.media.dto;

import com.lingosphinx.media.domain.ArtifactType;
import com.lingosphinx.media.domain.LanguageCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtifactImportDto {

    private List<ArtifactDto> artifacts;
}