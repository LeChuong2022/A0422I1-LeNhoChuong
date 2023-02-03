package com.furamam04.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id")
    private Long id;

    @Column(name = "attach_service_name", nullable = false, length = 45)
    private String name;

    @Column(name = "attach_service_cost", nullable = false)
    private Double attachServiceCost;

    @Column(name = "attach_service_unit", nullable = false)
    private Integer attachServiceUnit;

    @Column(name = "attach_service_status", length = 45)
    private String attachServiceStatus;

    @OneToMany(mappedBy = "attachService", fetch = FetchType.LAZY)
    private Set<ContractDetail> contractDetails;

    public AttachService() {
    }

    public AttachService(String name, Double attachServiceCost, Integer attachServiceUnit, String attachServiceStatus) {
        this.name = name;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
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

    public Double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(Double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public Integer getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(Integer attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }
}
