package models;

import java.util.Date;

public class Customer extends Person{
    private String typeOfCustomer;
    private String addressOfCustomer;

    public Customer(){
        super();
    }

    public Customer(int id, String name, Date dayOfBirth, String gender, int identityCardNumber, String phoneNumber, String email, String typeOfCustomer, String addressOfCustomer) {
        super(id, name, dayOfBirth, gender, identityCardNumber, phoneNumber, email);
        this.typeOfCustomer = typeOfCustomer;
        this.addressOfCustomer = addressOfCustomer;
    }

    public Customer(int id, String name, Date dayOfBirth, String gender, int identityCardNumber, String phoneNumber, String email) {
        super(id, name, dayOfBirth, gender, identityCardNumber, phoneNumber, email);
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public void setAddressOfCustomer(String addressOfCustomer) {
        this.addressOfCustomer = addressOfCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" + super.toString() +
                "typeOfCustomer='" + typeOfCustomer + '\'' +
                ", addressOfCustomer='" + addressOfCustomer + '\'' +
                '}';
    }
}
