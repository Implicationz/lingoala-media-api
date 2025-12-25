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
public class PromptTemplate extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

}