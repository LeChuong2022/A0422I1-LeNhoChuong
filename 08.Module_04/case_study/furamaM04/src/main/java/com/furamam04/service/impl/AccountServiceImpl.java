package com.furamam04.service.impl;

import com.furamam04.entity.Account;
import com.furamam04.repository.AccountRepository;
import com.furamam04.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return (List<Account>) accountRepository.findAll();
    }
}
