package com.furamam04.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id")
    private Long id;

    @Column(name = "customer_type_name", length = 45)
    private String name;

    @OneToMany(mappedBy = "customerType", fetch = FetchType.LAZY)
    private Set<Customer> customers;

    public CustomerType() {
    }

    public CustomerType(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
