package models;

public class Contract {
    private String id;
    private Booking booking;
    private String prepayment;
    private String pay;
    private Customer customer;

    public Contract(){}

    public Contract(String id, Booking booking, String prepayment, String pay, Customer customer) {
        this.id = id;
        this.booking = booking;
        this.prepayment = prepayment;
        this.pay = pay;
        this.customer = customer;
    }

}
