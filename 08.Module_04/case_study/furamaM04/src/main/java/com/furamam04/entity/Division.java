package com.furamam04.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @Column(name = "division_name", length = 45)
    private String name;

    @OneToMany(mappedBy = "division", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    public Division() {
    }

    public Division(String name) {
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
