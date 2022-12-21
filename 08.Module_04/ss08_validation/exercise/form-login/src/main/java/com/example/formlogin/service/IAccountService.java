package com.example.formlogin.service;

import com.example.formlogin.entity.Account;

import java.util.List;

public interface IAccountService {
    void save (Account account);
    List<Account> findAll();
}
