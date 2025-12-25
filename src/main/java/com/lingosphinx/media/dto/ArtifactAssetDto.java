package com.lingosphinx.media.dto;

import com.lingosphinx.media.domain.Artifact;
import com.lingosphinx.media.domain.ArtifactAssetType;
import com.lingosphinx.media.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtifactAssetDto {

    private ArtifactDto artifact;
    private ArtifactAssetType type;
    private String name;
    private String token;
}
