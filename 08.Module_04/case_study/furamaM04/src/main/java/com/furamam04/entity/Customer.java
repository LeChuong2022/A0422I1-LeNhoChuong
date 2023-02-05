package com.furamam04.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Pattern(regexp = "(KH)[-][\\d]{4}", message = "{customerId}")
    @Column(name = "customer_string_id")
    private String stringId;


    @Column(name = "customer_name", length = 45, nullable = false)
    private String name;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "customer_birthday", nullable = false)
    private Date customerBirthday;

    @Column(name = "customer_gender", nullable = false)
    private Boolean gender;

    @Pattern(regexp = "[\\d]{9}|[\\d]{12}", message = "{idCard}")
    @Column(name = "customer_id_card", nullable = false, length = 45)
    private String idCard;

    @Pattern(regexp = "(090)[\\d]{7}|(091)[\\d]{7}|\\(84\\)\\+90[\\d]{7}|\\(84\\)\\+91[\\d]{7}", message = "{phone}")
    @Column(name = "customer_phone", nullable = false, length = 45)
    private String phone;

    @Email(message = "{email}")
    @Column(name = "customer_email", length = 45)
    private String email;

    @Column(name = "customer_address", length = 45)
    private String address;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Contract> contracts;

    @ManyToOne()
    //            (cascade = CascadeType.ALL) - thêm cái này thì xóa luôn bên bảng quan hệ kia
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id", nullable = false)
    private CustomerType customerType;

    public Customer() {
    }

    public Customer(String name, Date customerBirthday, Boolean gender, String idCard, String phone, String email, String address) {
        this.name = name;
        this.customerBirthday = customerBirthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
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

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Boolean isGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getGender() {
        return gender;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
