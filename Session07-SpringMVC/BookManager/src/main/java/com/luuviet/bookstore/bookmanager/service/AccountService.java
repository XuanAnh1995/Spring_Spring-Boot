package com.luuviet.bookstore.bookmanager.service;

import com.luuviet.bookstore.bookmanager.entity.Account;
import com.luuviet.bookstore.bookmanager.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }
}
