package com.lingosphinx.media.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Artifact extends BaseEntity {

    @Column(nullable = false)
    private ArtifactType type;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private LanguageCode language;
    @ManyToOne(optional = false)
    private Account owner;
    private String content;
    private String tokenization;
    private String transliteration;

    @BatchSize(size = 30)
    @OneToMany(mappedBy = "artifact", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArtifactTranslation> translations;

    @BatchSize(size = 30)
    @OneToMany(mappedBy = "artifact", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArtifactAsset> assets;
}