package com.lingosphinx.media.mapper;

import com.lingosphinx.media.domain.Artifact;
import com.lingosphinx.media.domain.ArtifactMetadata;
import com.lingosphinx.media.dto.ArtifactDto;
import com.lingosphinx.media.dto.ArtifactMetadataDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ArtifactMetadataMapper {
    ArtifactMetadataDto toDto(ArtifactMetadata artifactMetadata);
    ArtifactMetadata toEntity(ArtifactMetadataDto artifactMetadataDto);

    @Mapping(target = "translations", ignore = true)
    ArtifactDto toDto(Artifact artifact);
    @Mapping(target = "translations", ignore = true)
    Artifact toEntity(ArtifactDto artifactDto);

    @Mapping(target = "artifact", ignore = true)
    void updateEntityFromDto(ArtifactMetadataDto artifactMetadataDto, @MappingTarget ArtifactMetadata artifactMetadata);
}
