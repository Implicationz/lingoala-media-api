package com.lingosphinx.media.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"artifact_id", "account_id"})
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtifactInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(optional = false)
    private Artifact artifact;

    @ManyToOne(optional = false)
    private Account account;

    private String currentPosition;
}