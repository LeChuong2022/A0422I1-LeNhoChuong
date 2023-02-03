package com.furamam04.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id")
    private Long id;

    @Column(name = "education_degree_name", length = 45)
    private String name;

    @OneToMany(mappedBy = "educationDegree", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    public EducationDegree() {
    }

    public EducationDegree(String name) {
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
