package com.lingosphinx.media.mapper;

import com.lingosphinx.media.domain.Account;
import com.lingosphinx.media.dto.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto toDto(Account entity);
    Account toEntity(AccountDto dto);


    void toEntityFromDto(AccountDto accountDto, @MappingTarget Account existingAccount);
}