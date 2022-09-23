package models;

import java.io.Serializable;
import java.util.Date;

public class Employee extends Person implements Serializable {
    private String degreeOfEmployee;
    private String potionOfEmployee;
    private int salary;

    public Employee() {
        super();
    }

    public Employee(int id, String name, Date dayOfBirth, String gender, int identityCardNumber, String phoneNumber, String email, String degreeOfEmployee, String potionOfEmployee, int salary) {
        super(id, name, dayOfBirth, gender, identityCardNumber, phoneNumber, email);
        this.degreeOfEmployee = degreeOfEmployee;
        this.potionOfEmployee = potionOfEmployee;
        this.salary = salary;
    }

    public String getDegreeOfEmployee() {
        return degreeOfEmployee;
    }

    public void setDegreeOfEmployee(String degreeOfEmployee) {
        this.degreeOfEmployee = degreeOfEmployee;
    }

    public String getPotionOfEmployee() {
        return potionOfEmployee;
    }

    public void setPotionOfEmployee(String potionOfEmployee) {
        this.potionOfEmployee = potionOfEmployee;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(int id, String name, Date dayOfBirth, String gender, int identityCardNumber, String phoneNumber, String email) {
        super(id, name, dayOfBirth, gender, identityCardNumber, phoneNumber, email);
    }


    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                "\tdegreeOfEmployee='" + degreeOfEmployee + '\'' +
                ",\tpotionOfEmployee='" + potionOfEmployee + '\'' +
                ",\tsalary=" + salary +
                '}';
    }

    ////

}
