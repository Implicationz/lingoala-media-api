package com.lingosphinx.media.mapper;

import com.lingosphinx.media.domain.ArtifactImport;
import com.lingosphinx.media.domain.ArtifactTranslation;
import com.lingosphinx.media.dto.ArtifactImportDto;
import com.lingosphinx.media.dto.ArtifactTranslationDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ArtifactImportMapper {
    ArtifactImportDto toDto(ArtifactImport artifactImport);
    ArtifactImport toEntity(ArtifactImportDto artifactImportDto);
}
