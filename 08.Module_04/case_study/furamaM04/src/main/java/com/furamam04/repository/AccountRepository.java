package com.furamam04.repository;

import com.furamam04.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<Account, String> {
    Account findByAccountName(String accountName);
}
