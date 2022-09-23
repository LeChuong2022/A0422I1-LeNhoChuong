package ss00_case_study.furama_resort.services.impl;

import ss00_case_study.furama_resort.models.Booking;
import ss00_case_study.furama_resort.models.Contract;
import ss00_case_study.furama_resort.models.Customer;
import ss00_case_study.furama_resort.services.ContractService;

import java.util.*;

public class ContractServiceImpl implements ContractService {

    static List<Contract> contractList = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

      @Override
    public void creatNewContract() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = new BookingServiceImpl().sendBooking();
        for (Booking booking : bookingSet) {
            bookingQueue.add(booking);
        }
        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();
            Customer customer = booking.getCustomer();

            System.out.println("Creating contract for booking have information: " + booking.toString());
            System.out.println("Creating contract for customer have information: " + customer.toString());
            System.out.println("Enter id of contract: ");
            String id = scanner.nextLine();
            System.out.println("Enter money prepay ");
            String prepay = scanner.nextLine();
            System.out.println("Enter total money pay");
            String totalPay = scanner.nextLine();

            Contract contract = new Contract(id, booking, prepay, totalPay, customer);
            contractList.add(contract);
            System.out.println("Created contract success: " + contract.toString());
        }
    }

    @Override
    public void displayListContract() {
        for (Contract contract : contractList)
            System.out.println(contract.toString());
    }

    @Override
    public void editContract() {
        System.out.println("Enter id of contract want edit: ");
        String id = scanner.nextLine();
        for (Contract contract : contractList) {
            if (id.equals(contract.getIdContract())) {
                int index = contractList.indexOf(contract);
                System.out.println("Enter money prepay ");
                String prepay = scanner.nextLine();
                System.out.println("Enter total money pay");
                String totalPay = scanner.nextLine();
                Contract contract1 = new Contract(id, contract.getBooking(), prepay,totalPay, contract.getCustomer());
                contractList.set(index,contract1);
            }
        }
    }
}
