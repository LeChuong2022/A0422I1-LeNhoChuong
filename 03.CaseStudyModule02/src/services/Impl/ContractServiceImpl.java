package services.Impl;

import models.Booking;
import models.Contract;
import models.Customer;
import services.ContractService;

import java.util.*;

public class ContractServiceImpl implements ContractService {

    static List<Contract> contractList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void createNewContract() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = new BookingServiceImpl().sendBooking();
        for (Booking booking : bookingSet) {
            bookingQueue.add(booking);
        }
        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();
            Customer customer = booking.getCustomer();

            System.out.println("Creating contract for booking: " + booking.toString());
            System.out.println("Creating contract for booking: " + customer.toString());
            System.out.println("Id of contract: ");
            String id = scanner.nextLine();
            System.out.println("Enter prepayment amount: ");
            String prepayment = scanner.nextLine();
            System.out.println("Enter expenses: ");
            String pay = scanner.nextLine();

            Contract contract = new Contract(id, booking, prepayment, pay, customer);
            contractList.add(contract);
            System.out.println("Create new contract finish");
        }

    }

    @Override
    public void displayListContract() {
        for (Contract contract : contractList) {
            System.out.println(contract.toString());
        }
    }

}
