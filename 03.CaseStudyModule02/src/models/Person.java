package models;

import java.io.Serializable;
import java.util.Date;

public abstract class Person implements Serializable {
    private int id;
    private String name;
    private Date dayOfBirth;
    private String gender;
    private int identityCardNumber;
    private String phoneNumber;
    private String email;

    public Person(){}

    public Person(int id, String name, Date dayOfBirth, String gender, int identityCardNumber, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.identityCardNumber = identityCardNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(int identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String displayDay = (dayOfBirth.toString()).replaceAll(" 00:00:00 ICT", "");
        return  "\tid=" + id +
                ",\tname='" + name + '\'' +
                ",\tDay of birth='" + displayDay + '\'' +
                ",\tgender='" + gender + '\'' +
                ",\tidentityCardNumber=" + identityCardNumber +
                ",\tphoneNumber=" + phoneNumber +
                ",\temail='" + email + '\'' + ",";
    }
}
