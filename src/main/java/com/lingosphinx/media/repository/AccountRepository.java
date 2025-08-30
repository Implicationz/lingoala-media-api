package com.lingosphinx.media.repository;

import com.lingosphinx.media.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Override
    Optional<Account> findById(Long id);

    Optional<Account> findByUserId(UUID userId);
}
