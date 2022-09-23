package ss00_case_study.furama_resort.models;

public class Customer extends Person{
    private String typeCustomer;

    public Customer() {
    }

    public Customer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public Customer(int id, String name, String dateOfBirth, String gender, String idCard, String phoneNumber, String email, String address, String typeCustomer) {
        super(id, name, dateOfBirth, gender, idCard, phoneNumber, email, address);
        this.typeCustomer = typeCustomer;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" +super.toString() +
                "typeCustomer='" + typeCustomer + '\'' +
                '}';
    }
}
