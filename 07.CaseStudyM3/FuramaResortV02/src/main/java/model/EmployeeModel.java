package model;

import java.sql.Date;

public class EmployeeModel extends AbstractPersonModel {
    private Double salary;

    private int positionId; //foreign key
    private int educationDegreeId; //foreign key
    private int divisionId; //foreign key
    private String userName; //foreign key

    public EmployeeModel() {
    }

    public EmployeeModel(int id, String name, Date birthday, String idCard, String phone, String email, String address) {
        super(id, name, birthday, idCard, phone, email, address);
    }

    public EmployeeModel(int id, String name, Date birthday, String idCard, String phone, String email, String address, Double salary, int positionId, int educationDegreeId, int divisionId, String userName) {
        super(id, name, birthday, idCard, phone, email, address);
        this.salary = salary;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
        this.userName = userName;
    }

    public EmployeeModel(String name, Date birthday, String idCard, String phone, String email, String address, Double salary, int positionId, int educationDegreeId, int divisionId, String userName) {
        super(name, birthday, idCard, phone, email, address);
        this.salary = salary;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
        this.userName = userName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
