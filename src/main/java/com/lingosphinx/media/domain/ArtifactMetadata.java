package com.lingosphinx.media.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ArtifactMetadata extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(unique = true)
    private Artifact artifact;

    @Convert(converter = MapToJsonConverter.class)
    @Column(columnDefinition = "TEXT")
    private Map<String, String> attributes;
}