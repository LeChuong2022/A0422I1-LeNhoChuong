package com.furamam04.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_string_id")
    private String stringId;

    @Column(name = "employee_name", nullable = false, length = 45)
    private String name;

    @Column(name = "employee_birthday", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeBirthday;

    @Column(name = "employee_id_card", nullable = false, length = 45)
    private String idCard;

    @Column(name = "employee_salary", nullable = false)
    private Double salary;

    @Column(name = "employee_phone", nullable = false, length = 45)
    private String phone;

    @Column(name = "employee_email", length = 45)
    private String email;

    @Column(name = "employee_address", length = 45)
    private String address;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private Set<Contract> contracts;

    @ManyToOne
    //            (cascade = CascadeType.ALL) - thêm cái này thì xóa luôn bên bảng quan hệ kia
    @JoinColumn(name = "position_id", referencedColumnName = "position_id", nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "education_degree_id", nullable = false)
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "division_id", nullable = false)
    private Division division;

    @ManyToOne(cascade = CascadeType.ALL) // thêm cái này thì xóa luôn bên bảng quan hệ kia
    @JoinColumn(name = "accountname", referencedColumnName = "account_name")
    private Account account;

    public Employee() {
    }

    public Employee(String name, Date employeeBirthday, String idCard, Double salary, String phone, String email, String address) {
        this.name = name;
        this.employeeBirthday = employeeBirthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Employee(String stringId, String name, Date employeeBirthday, String idCard, Double salary, String phone, String email, String address) {
        this.stringId = stringId;
        this.name = name;
        this.employeeBirthday = employeeBirthday;
        this.idCard = idCard;
        this.salary = salary;
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

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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

    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
