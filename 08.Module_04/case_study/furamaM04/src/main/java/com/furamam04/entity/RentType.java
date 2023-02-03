package com.furamam04.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id")
    private Long id;

    @Column(name = "rent_type_name", length = 45)
    private String name;

    @Column(name = "rent_type_cost")
    private Double rentTypeCost;

    @OneToMany(mappedBy = "rentType", fetch = FetchType.LAZY)
    private Set<Service> services;

    public RentType() {
    }

    public RentType(String name, Double rentTypeCost) {
        this.name = name;
        this.rentTypeCost = rentTypeCost;
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

    public Double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(Double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }
}
