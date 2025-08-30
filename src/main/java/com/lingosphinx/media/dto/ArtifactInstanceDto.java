package com.lingosphinx.media.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtifactInstanceDto {

    private Long id;
    private ArtifactDto artifact;
    private AccountDto account;
    private String currentPosition;
}