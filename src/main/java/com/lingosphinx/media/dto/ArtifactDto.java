package com.lingosphinx.media.dto;

import com.lingosphinx.media.domain.ArtifactAsset;
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
public class ArtifactDto {
    
    private Long id;
    private ArtifactType type;
    private String title;
    private LanguageCode language;
    private AccountDto owner;
    private String content;
    private String tokenization;
    private String transliteration;
    private List<ArtifactTranslationDto> translations;
    private List<ArtifactAssetDto> assets;
}