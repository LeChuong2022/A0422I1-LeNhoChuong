package services.Impl;

import exception.UserException;
import models.Customer;
import models.Employee;
import models.Person;
import services.CustomerService;
import validate.Validator;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static List<Customer> customerLinkedList = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    static {
        Date dayOfBirthCustomer1 = null;
        Date dayOfBirthCustomer2 = null;
        Date dayOfBirthCustomer3 = null;
        try {
            dayOfBirthCustomer1 = Validator.validateDayOfBirth("4/7/1989");
            dayOfBirthCustomer2 = Validator.validateDayOfBirth("6/8/1985");
            dayOfBirthCustomer3 = Validator.validateDayOfBirth("14/9/1981");
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
        Customer c1 = new Customer(1, "Tran Van A", dayOfBirthCustomer1, "male", 206534524, "0984657679", "tranvana@gmail.com", "Diamond", "Quang Nam");
        Customer c2 = new Customer(2, "Tran Van B", dayOfBirthCustomer2, "male", 204635473, "0912312859", "tranvanb@gmail.com", "Gold", "Hue");
        Customer c3 = new Customer(3, "Tran Thi C", dayOfBirthCustomer3, "female", 234659876, "0946532579", "tranthic@gmail.com", "Sliver", "Quang Binh");
        customerLinkedList.add(c1);
        customerLinkedList.add(c2);
        customerLinkedList.add(c3);
    }

    public void displayCustomerList() {
/*        System.out.println("\n--------Customer List--------");
        int id = 0;
        for (Customer customer : customerLinkedList) {
            customer.setId(++id);
            System.out.println(customer.toString());
        }

 */
    }

    public void addCustomer(Customer e) {
        customerLinkedList.add(e);
    }

    public void editCustomer(int id, Customer e) {
        customerLinkedList.set(id - 1, e);
    }
    /////lam mooi tu day

    public Customer enterInformation() {
        String option = "customer";
        System.out.print("Id of " + option + ": ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Name of " + option + ": ");
        String name = scanner.nextLine();

        Date dayOfBirth = null;
        do {
            System.out.print("Employee's day of birth': ");
            try {
                dayOfBirth = Validator.validateDayOfBirth(scanner.nextLine());
                break;
            } catch (UserException e) {
                e.printStackTrace();
            }
        } while (true);

        System.out.print("Gender of " + option + ": ");
        String gender = scanner.nextLine();

        System.out.print("Identity Card Number of " + option + ": ");
        int identityCardNumber = Integer.parseInt(scanner.nextLine());

        System.out.print("Phone's number of " + option + ": ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Email of " + option + ": ");
        String email = scanner.nextLine();

        System.out.print("Type of customer: ");
        String typeOfCustomer = scanner.nextLine();

        System.out.print("Address of customer: ");
        String addressOfCustomer = scanner.nextLine();

        Customer customer = new Customer(id, name, dayOfBirth, gender, identityCardNumber, phoneNumber, email, typeOfCustomer, addressOfCustomer);

        return customer;
    }


    @Override
    public void display() {
        System.out.println("\n--------Customer List--------");
        for (Customer customer : customerLinkedList) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void addNew() {
        System.out.println("\nAdd new customer: ");
        Customer customer = enterInformation();
        customerLinkedList.add(customer);
        System.out.println("Finish add customer \n-----------");
    }

    @Override
    public void edit() {
        System.out.println("\nEdit customer: ");
        System.out.print("Select the id that you want to edit: ");
        int id = scanner.nextInt();

        Customer customer = enterInformation();
        customerLinkedList.set(id - 1, customer);
        System.out.println("Finish edit customer \n-----------");
    }

    @Override
    public void delete() {

    }
}
