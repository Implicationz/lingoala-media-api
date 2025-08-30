package com.lingosphinx.media.service;

import com.lingosphinx.media.domain.Account;
import com.lingosphinx.media.dto.AccountDto;

import java.util.List;

public interface AccountService {

    Account registerCurrent();

    AccountDto create(AccountDto account);

    AccountDto readById(Long id);
    List<AccountDto> readAll();
    AccountDto update(Long id, AccountDto account);
    void delete(Long id);

    Account readCurrent();


}
