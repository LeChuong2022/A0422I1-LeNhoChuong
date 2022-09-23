package ss00_case_study.furama_resort.services.impl;

import ss00_case_study.furama_resort.models.Booking;
import ss00_case_study.furama_resort.models.Customer;
import ss00_case_study.furama_resort.models.Facility;
import ss00_case_study.furama_resort.models.Villa;
import ss00_case_study.furama_resort.services.BookingService;
import ss00_case_study.furama_resort.utils.BookingComparator;

import java.util.*;

public class BookingServiceImpl implements BookingService{

    static Scanner scanner = new Scanner(System.in);

    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    static List<Customer> customerList = new ArrayList<>();

    static Map<Facility,Integer> facilityIntegerMap = new LinkedHashMap<>();

    static {
        customerList.add(new Customer(1,"long","20","Male","12Lo",
                "0905117090","long@gmail.com","ĐN","VIP"));
        customerList.add(new Customer(2,"Nam","30","Male","12Na",
                "0905117090","nam@gmail.com","SG","NORMAL"));
        facilityIntegerMap.put(new Villa("1", "Villa1", 300, 1000,
                4, "Day", "Vip", 2, 200),0);
        facilityIntegerMap.put(new Villa("2", "Villa2", 400, 2000,
                5, "Day", "Normal", 3, 400),0);
    }

    public Set<Booking> sendBooking(){
        return bookingSet;
    }

    @Override
    public void addBooking()  {
        int id = 1;
        if(!bookingSet.isEmpty()){
            id=bookingSet.size()+1;
        }
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();
        System.out.println("Enter start of date for rent: ");
        String startDate = scanner.nextLine();
        System.out.println("Enter end of date for rent: ");
        String endDate = scanner.nextLine();
        Booking booking = new Booking(id,startDate,endDate,customer,facility);
        bookingSet.add(booking);
        System.out.println("Booked success");
    }

    @Override
    public void displayListBooking() {
        for(Booking booking: bookingSet)
            System.out.println(booking.toString());
    }

    public static Customer chooseCustomer(){
        System.out.println("List customer: ");
        for (Customer customer: customerList)
            System.out.println(customer.toString());

        System.out.println("Enter id of customer: ");
        boolean check = true;
        int id = Integer.parseInt(scanner.nextLine());

        while (check){
            for(Customer customer: customerList){
                if(id == customer.getId()){
                    check = false;
                    return customer;
                }
            }
            if(check){
                System.out.println("You enter wrong id, please enter id of customer again: ");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
        return null;
    }

    public static Facility chooseFacility(){
        System.out.println("List facility: ");
        for (Map.Entry<Facility,Integer> entry: facilityIntegerMap.entrySet()) {
            System.out.println(entry.getKey().toString());
        }

        System.out.println("Enter id of facility: ");
        boolean check = true;
        String id = scanner.nextLine();

        while (check){
            for(Map.Entry<Facility,Integer> entry: facilityIntegerMap.entrySet()){
                if(id.equals(entry.getKey().getIdFacility())){
                    check = false;
                    return entry.getKey();
                }
            }
            if(check){
                System.out.println("You enter wrong id, please enter id of facility again: ");
                id = scanner.nextLine();
            }
        }
        return null;
    }
}
