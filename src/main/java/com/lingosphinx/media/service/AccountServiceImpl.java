package com.lingosphinx.media.service;

import com.lingosphinx.media.domain.Account;
import com.lingosphinx.media.dto.AccountDto;
import com.lingosphinx.media.exception.ResourceNotFoundException;
import com.lingosphinx.media.mapper.AccountMapper;
import com.lingosphinx.media.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService {

    private final UserService userService;
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public Account registerCurrent() {
        var userId = this.userService.getCurrentUserId();
        var registered = this.accountRepository.findByUserId(userId).orElseGet(() -> {
            var account = new Account();
            account.setUserId(userId);
            var savedAccount = accountRepository.save(account);
            log.info("Account registered successfully: id={}", savedAccount.getId());
            return savedAccount;
        });
        return registered;
    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        var account = accountMapper.toEntity(accountDto);
        var savedAccount = accountRepository.save(account);
        log.info("Account created successfully: id={}", savedAccount.getId());
        return accountMapper.toDto(savedAccount);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountDto readById(Long id) {
        var account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        return this.accountMapper.toDto(account);
    }


    @Override
    @Transactional(readOnly = true)
    public List<AccountDto> readAll() {
        var result = accountRepository.findAll().stream()
                .map(accountMapper::toDto)
                .toList();
        log.info("All accounts read successfully, count={}", result.size());
        return result;
    }

    @Override
    public AccountDto update(Long id, AccountDto accountDto) {
        var existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));

        accountMapper.toEntityFromDto(accountDto, existingAccount);
        log.info("Account updated successfully: id={}", existingAccount.getId());
        return accountMapper.toDto(existingAccount);
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
        log.info("Account deleted successfully: id={}", id);
    }

    @Override
    public Account readCurrent() {
        var userId = this.userService.getCurrentUserId();
        return this.accountRepository.findByUserId(userId).orElseThrow(() -> new ResourceNotFoundException("Current Account not found"));
    }

}