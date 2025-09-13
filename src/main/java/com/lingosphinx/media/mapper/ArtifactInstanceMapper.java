package com.lingosphinx.media.mapper;

import com.lingosphinx.media.domain.ArtifactInstance;
import com.lingosphinx.media.domain.ArtifactTranslation;
import com.lingosphinx.media.dto.ArtifactInstanceDto;
import com.lingosphinx.media.dto.ArtifactTranslationDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ArtifactInstanceMapper {
    ArtifactInstanceDto toDto(ArtifactInstance artifactInstance);
    ArtifactInstance toEntity(ArtifactInstanceDto artifactInstanceDto);

    @Mapping(target = "artifact", ignore = true)
    ArtifactTranslationDto toDto(ArtifactTranslation artifactTranslation);
    @Mapping(target = "artifact", ignore = true)
    ArtifactTranslation toEntity(ArtifactTranslationDto ArtifactTranslationDto);

    @Mapping(target = "account", ignore = true)
    @Mapping(target = "artifact", ignore = true)
    void updateEntityFromDto(ArtifactInstanceDto artifactInstanceDto, @MappingTarget ArtifactInstance artifactInstance);
}
