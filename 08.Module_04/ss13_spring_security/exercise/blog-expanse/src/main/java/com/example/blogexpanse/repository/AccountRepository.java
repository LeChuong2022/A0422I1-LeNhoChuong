package com.example.blogexpanse.repository;

import com.example.blogexpanse.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
    Account findByAccountName(String accountName);
}
