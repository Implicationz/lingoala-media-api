package com.lingosphinx.media.service;

import com.lingosphinx.media.dto.PromptTemplateDto;
import com.lingosphinx.media.exception.ResourceNotFoundException;
import com.lingosphinx.media.mapper.PromptTemplateMapper;
import com.lingosphinx.media.repository.PromptTemplateRepository;
import com.lingosphinx.media.utility.EntitySyncUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PromptTemplateServiceImpl implements PromptTemplateService {

    private final PromptTemplateRepository promptTemplateRepository;
    private final PromptTemplateMapper promptTemplateMapper;
    private final AccountService accountService;

    @Override
    public PromptTemplateDto create(PromptTemplateDto promptTemplateDto) {
        var promptTemplate = promptTemplateMapper.toEntity(promptTemplateDto);
        var savedPromptTemplate = promptTemplateRepository.save(promptTemplate);
        log.info("PromptTemplate created with id: {}", savedPromptTemplate.getId());
        return promptTemplateMapper.toDto(savedPromptTemplate);
    }

    @Override
    @Transactional(readOnly = true)
    public PromptTemplateDto readById(Long id) {
        var promptTemplate = promptTemplateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PromptTemplate not found"));
        log.info("PromptTemplate found with id: {}", id);
        return promptTemplateMapper.toDto(promptTemplate);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PromptTemplateDto> readAll() {
        log.info("Reading all promptTemplates");
        return promptTemplateRepository.findAll().stream()
                .map(promptTemplateMapper::toDto)
                .toList();
    }

    @Override
    public PromptTemplateDto update(Long id, PromptTemplateDto promptTemplateDto) {
        var existingPromptTemplate = promptTemplateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PromptTemplate not found"));
        promptTemplateMapper.updateEntityFromDto(promptTemplateDto, existingPromptTemplate);
        log.info("PromptTemplate updated with id: {}", id);
        return promptTemplateMapper.toDto(existingPromptTemplate);
    }

    @Override
    public void delete(Long id) {
        promptTemplateRepository.deleteById(id);
        log.info("PromptTemplate deleted with id: {}", id);
    }
}