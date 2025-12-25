package com.lingosphinx.media.dto;

import com.lingosphinx.media.domain.Account;
import com.lingosphinx.media.domain.ArtifactTranslation;
import com.lingosphinx.media.domain.ArtifactType;
import com.lingosphinx.media.domain.LanguageCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromptTemplateDto {

    private Long id;
    private String name;

}