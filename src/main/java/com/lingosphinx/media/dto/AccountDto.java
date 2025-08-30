package com.lingosphinx.media.dto;

import com.lingosphinx.media.domain.AccessLevel;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountDto {

    private Long id;
    private UUID userId;
    @Builder.Default
    private AccessLevel accessLevel = AccessLevel.FREE;
}