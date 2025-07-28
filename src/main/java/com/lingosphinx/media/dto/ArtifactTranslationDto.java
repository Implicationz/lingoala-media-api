package com.lingosphinx.media.dto;

import com.lingosphinx.media.domain.LanguageCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtifactTranslationDto {

    private Long id;
    private ArtifactDto artifact;
    private LanguageCode language;
    private String token;
}