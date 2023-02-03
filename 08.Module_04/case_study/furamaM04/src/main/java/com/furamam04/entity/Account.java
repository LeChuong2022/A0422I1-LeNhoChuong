package com.furamam04.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Account {
    @Id
    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Column(nullable = false, length = 255)
    private String password;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    public Account() {
    }

    public Account(String password) {
        this.password = password;
    }

    public Account(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
