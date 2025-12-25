package com.lingosphinx.media.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ArtifactTranslation extends BaseEntity {

    @ManyToOne(optional = false)
    private Artifact artifact;
    @Column(nullable = false)
    private LanguageCode language;
    private String token;
}