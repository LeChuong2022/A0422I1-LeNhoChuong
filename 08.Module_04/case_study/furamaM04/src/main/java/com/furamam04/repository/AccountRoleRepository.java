package com.furamam04.repository;

import com.furamam04.entity.AccountRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRoleRepository extends CrudRepository<AccountRole, Long> {
    @Query("select ar.role.roleName from AccountRole ar where ar.account.accountName =:accountName")
    List<String> findAllRoleByUser(String accountName);
}
