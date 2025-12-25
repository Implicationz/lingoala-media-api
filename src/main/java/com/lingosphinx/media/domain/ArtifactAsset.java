package com.lingosphinx.media.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"artifact_id", "type", "name"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ArtifactAsset extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "artifact_id", nullable = false)
    private Artifact artifact;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ArtifactAssetType type;

    @Column(nullable = false)
    private String name;

    private String token;
}
