package com.lingosphinx.media.controller;


import com.lingosphinx.media.dto.PromptTemplateDto;
import com.lingosphinx.media.service.PromptTemplateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prompt-template")
@RequiredArgsConstructor
@Tag(name = "PromptTemplate API")
public class PromptTemplateController {

    private final PromptTemplateService promptTemplateService;

    @PostMapping
    public ResponseEntity<PromptTemplateDto> create(@RequestBody @Valid PromptTemplateDto promptTemplate) {
        return ResponseEntity.status(HttpStatus.CREATED).body(promptTemplateService.create(promptTemplate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromptTemplateDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(promptTemplateService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<PromptTemplateDto>> readAll() {
        return ResponseEntity.ok(promptTemplateService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PromptTemplateDto> update(@PathVariable Long id, @RequestBody @Valid PromptTemplateDto promptTemplate) {
        return ResponseEntity.ok(promptTemplateService.update(id, promptTemplate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        promptTemplateService.delete(id);
        return ResponseEntity.noContent().build();
    }
}