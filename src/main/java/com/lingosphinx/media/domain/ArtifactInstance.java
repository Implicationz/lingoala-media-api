package com.lingosphinx.media.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"artifact_id", "account_id"})
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ArtifactInstance extends BaseEntity {

    @ManyToOne(optional = false)
    private Artifact artifact;

    @ManyToOne(optional = false)
    private Account account;

    private String currentPosition;
}