package services.Impl;

import exception.UserException;
import models.Booking;
import models.Customer;
import models.Facility;
import models.Villa;
import services.BookingService;
import utils.BookingComparator;
import validate.Validator;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Scanner scanner = new Scanner(System.in);

    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    static List<Customer> customerList = new ArrayList<>();

    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();

    static {
        Date dayOfBirthCustomer4 = null;
        Date dayOfBirthCustomer5 = null;
        Date dayOfBirthCustomer6 = null;
        try {
            dayOfBirthCustomer4 = Validator.validateDayOfBirth("8/9/1992");
            dayOfBirthCustomer5 = Validator.validateDayOfBirth("1/9/1972");
            dayOfBirthCustomer6 = Validator.validateDayOfBirth("8/12/1994");
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
        customerList.add(new Customer(4, "Tran Thi D", dayOfBirthCustomer4, "female", 234659881, "0946532102", "tranthid@gmail.com", "Gold", "Ha Nam"));
        customerList.add(new Customer(5, "Tran Van Bao", dayOfBirthCustomer5, "male", 432659881, "0142342102", "bao.tv@gmail.com", "Gold", "Nam Dinh"));
        customerList.add(new Customer(6, "Tran Van Tuan", dayOfBirthCustomer6, "male", 123659881, "0234532102", "tuan.tv@gmail.com", "Gold", "Dong Thap"));

        facilityIntegerMap.put(new Villa("1", "Villa 1", 200, 150, 10, "Day", "Vip", 100, 1), 0);
        facilityIntegerMap.put(new Villa("2", "Villa 2", 300, 250, 12, "Day", "Normal", 100, 1), 0);
    }

    public Set<Booking> sendBooking(){
        return bookingSet;
    }
    public static Customer chooseCustomer() {
        System.out.println("Customer list:");
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
        System.out.printf("Enter id of customer: ");
        int id = Integer.parseInt(scanner.nextLine());

        while (true) {
            for (Customer customer : customerList) {
                if (id == customer.getId())
                    return customer;
            }
            System.out.printf("You entered wrong. Enter id of customer again: ");
            id = Integer.parseInt(scanner.nextLine());
        }
    }

    public static Facility chooseFacility() {
        System.out.println("Facility list:");
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            System.out.println(entry.getKey().toString());
        }
        System.out.printf("Enter id of service: ");
        String idFacility = scanner.nextLine();

        while (true) {
            for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
                if (idFacility.equals(entry.getKey().getIdFacility()))
                    return entry.getKey();
            }
            System.out.printf("You entered wrong. Enter id of service again: ");
            idFacility = scanner.nextLine();
        }
    }

    @Override
    public void displayListBooking() {
        for (Booking booking : bookingSet)
            System.out.println(booking.toString());
    }

    @Override
    public void addBooking() {
        int id = 1;
        if (!bookingSet.isEmpty()) {
            id = bookingSet.size();
        }
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();
        System.out.println("Enter rental start date: ");
        String startDate = scanner.nextLine();

        System.out.println("Enter check-out date: ");
        String endDate = scanner.nextLine();

        Booking booking = new Booking(id, startDate, endDate, customer, facility);
        bookingSet.add(booking);

        System.out.println("Finish booking");

    }
}
