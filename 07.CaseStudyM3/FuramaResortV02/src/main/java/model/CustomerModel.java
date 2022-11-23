package model;

import java.sql.Date;

public class CustomerModel extends AbstractPersonModel {
    private int customerTypeId;  //foreign key
    private boolean customerGender;

    public CustomerModel() {
    }

    public CustomerModel(int customerTypeId, boolean customerGender) {
        this.customerTypeId = customerTypeId;
        this.customerGender = customerGender;
    }

    public CustomerModel(int id, String name, Date birthday, String idCard, String phone, String email, String address) {
        super(id, name, birthday, idCard, phone, email, address);
    }

    public CustomerModel(int id, String name, Date birthday, String idCard, String phone, String email, String address, int customerTypeId, boolean customerGender) {
        super(id, name, birthday, idCard, phone, email, address);
        this.customerTypeId = customerTypeId;
        this.customerGender = customerGender;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public boolean isCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(boolean customerGender) {
        this.customerGender = customerGender;
    }
}

