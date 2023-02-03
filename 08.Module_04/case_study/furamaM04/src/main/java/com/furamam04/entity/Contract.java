package com.furamam04.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long id;

    @Column(name = "contract_start_date", nullable = false)
    private Date contractStartDate;

    @Column(name = "contract_end_date", nullable = false)
    private Date contractEndDate;

    @Column(name = "contract_deposit", nullable = false)
    private Double contractDeposit;

    @Column(name = "contract_total_money", nullable = false)
    private Double contractTotalMoney;

    @OneToMany(mappedBy = "contract", fetch = FetchType.LAZY)
    private Set<ContractDetail> contractDetails;

    @ManyToOne
    //            (cascade = CascadeType.ALL) - thêm cái này thì xóa luôn bên bảng quan hệ kia
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id", nullable = false)
    private Service service;

    public Contract() {
    }

    public Contract(Date contractStartDate, Date contractEndDate, Double contractDeposit, Double contractTotalMoney) {
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }
}
