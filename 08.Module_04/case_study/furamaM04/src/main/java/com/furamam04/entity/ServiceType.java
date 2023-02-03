package com.furamam04.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private Long id;

    @Column(name = "service_tyoe_name", length = 45)
    private String name;

    public ServiceType() {
    }

    @OneToMany(mappedBy = "serviceType", fetch = FetchType.LAZY)
    private Set<Service> services;

    public ServiceType(String name) {
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
