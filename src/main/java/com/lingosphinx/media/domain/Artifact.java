package com.lingosphinx.media.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Artifact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

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
}