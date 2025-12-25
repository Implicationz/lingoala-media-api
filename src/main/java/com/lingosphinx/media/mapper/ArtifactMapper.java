package com.lingosphinx.media.mapper;

import com.lingosphinx.media.domain.Artifact;
import com.lingosphinx.media.domain.ArtifactAsset;
import com.lingosphinx.media.domain.ArtifactTranslation;
import com.lingosphinx.media.dto.ArtifactAssetDto;
import com.lingosphinx.media.dto.ArtifactDto;
import com.lingosphinx.media.dto.ArtifactTranslationDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ArtifactMapper {
    ArtifactDto toDto(Artifact artifact);
    Artifact toEntity(ArtifactDto artifactDto);

    @Mapping(target = "artifact", ignore = true)
    ArtifactTranslationDto toDto(ArtifactTranslation artifactTranslation);
    @Mapping(target = "artifact", ignore = true)
    ArtifactTranslation toEntity(ArtifactTranslationDto ArtifactTranslationDto);

    @Mapping(target = "translations", ignore = true)
    @Mapping(target = "assets", ignore = true)
    void updateEntityFromDto(ArtifactDto artifactDto, @MappingTarget Artifact artifact);

    @Mapping(target = "artifact", ignore = true)
    void updateEntityFromDto(ArtifactTranslationDto artifactTranslationDto, @MappingTarget ArtifactTranslation artifactTranslation);

    @Mapping(target = "artifact", ignore = true)
    void updateEntityFromDto(ArtifactAssetDto artifactAssetDto, @MappingTarget ArtifactAsset artifactAsset);
}
