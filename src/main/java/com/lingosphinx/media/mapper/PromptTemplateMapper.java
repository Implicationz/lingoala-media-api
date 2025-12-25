package com.lingosphinx.media.mapper;

import com.lingosphinx.media.domain.PromptTemplate;
import com.lingosphinx.media.dto.PromptTemplateDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface PromptTemplateMapper {
    PromptTemplateDto toDto(PromptTemplate promptTemplate);
    PromptTemplate toEntity(PromptTemplateDto promptTemplateDto);

    void updateEntityFromDto(PromptTemplateDto promptTemplateDto, @MappingTarget  PromptTemplate existingPromptTemplate);
}
