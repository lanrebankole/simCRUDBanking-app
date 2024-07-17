package com.banking.app.banking_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.app.banking_app.entity.Account;

public interface AccountRepos extends JpaRepository<Account, Long> {

}
