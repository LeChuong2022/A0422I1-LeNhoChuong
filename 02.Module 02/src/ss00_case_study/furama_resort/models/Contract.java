package ss00_case_study.furama_resort.models;

public class Contract {
    private String idContract;
    private Booking booking;
    private String prePay;
    private String totalPay;
    private Customer customer;

    public Contract(){}

    public String getIdContract() {
        return idContract;
    }

    public void setIdContract(String idContract) {
        this.idContract = idContract;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getPrePay() {
        return prePay;
    }

    public void setPrePay(String prePay) {
        this.prePay = prePay;
    }

    public String getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(String totalPay) {
        this.totalPay = totalPay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Contract(String idContract, Booking booking, String prePay, String totalPay, Customer customer) {
        this.idContract = idContract;
        this.booking = booking;
        this.prePay = prePay;
        this.totalPay = totalPay;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "idContract='" + idContract + '\'' +
                ", booking=" + booking +
                ", prePay='" + prePay + '\'' +
                ", totalPay='" + totalPay + '\'' +
                ", customer=" + customer +
                '}';
    }
}
