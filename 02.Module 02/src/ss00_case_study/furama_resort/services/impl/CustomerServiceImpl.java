package ss00_case_study.furama_resort.services.impl;

import ss00_case_study.furama_resort.exception.UserException;
import ss00_case_study.furama_resort.models.Customer;
import ss00_case_study.furama_resort.services.CustomerService;
import ss00_case_study.furama_resort.validate.Validator;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static List<Customer> customerLinkedList = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Customer customer : customerLinkedList)
            System.out.println(customer.toString());
    }

    @Override
    public void addNew() {
        System.out.println("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        String name = null;
        do {
            System.out.println("Enter name:");
            name = scanner.nextLine();
            try {
                Validator.validateName(name);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        Date birthday = null;
        String dateOfBirth;
        do {
            System.out.println("Enter date of birth: ");
            dateOfBirth = scanner.nextLine();
            try {
                birthday = Validator.validateBirthday(dateOfBirth);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        System.out.println("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.println("Enter id card: ");
        String idCard = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter address: ");
        String address = scanner.nextLine();
        System.out.println("Enter type customer: ");
        String typeCustomer = scanner.nextLine();
        Customer customer = new Customer(id, name, dateOfBirth, gender, idCard, phoneNumber, email, address, typeCustomer);
        customerLinkedList.add(customer);
        System.out.println("Add customer success");
    }

    @Override
    public void edit() {
        System.out.println("Enter id of customer need edit");
        int id = Integer.parseInt(scanner.nextLine());
        for (Customer customer : customerLinkedList) {
            if (id == customer.getId()) {
                int index = customerLinkedList.indexOf(customer);

                String name = null;
                do {
                    System.out.println("Enter name:");
                    name = scanner.nextLine();
                    try {
                        Validator.validateName(name);
                        break;
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);

                Date birthday = null;
                String dateOfBirth;
                do {
                    System.out.println("Enter date of birth: ");
                    dateOfBirth = scanner.nextLine();
                    try {
                        birthday = Validator.validateBirthday(dateOfBirth);
                        break;
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);

                System.out.println("Enter gender: ");
                String gender = scanner.nextLine();
                System.out.println("Enter id card: ");
                String idCard = scanner.nextLine();
                System.out.println("Enter phone number: ");
                String phoneNumber = scanner.nextLine();
                System.out.println("Enter email: ");
                String email = scanner.nextLine();
                System.out.println("Enter address: ");
                String address = scanner.nextLine();
                System.out.println("Enter type customer: ");
                String typeCustomer = scanner.nextLine();
                Customer customerEdit = new Customer(id, name, dateOfBirth, gender, idCard, phoneNumber, email, address, typeCustomer);
                customerLinkedList.set(index, customerEdit);
            }
        }
        System.out.println("Edited customer success");
    }

    @Override
    public void delete() {
        System.out.println("Enter id of customer need delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Customer customer : customerLinkedList) {
            if (id == customer.getId()) {
                int index = customerLinkedList.indexOf(customer);
                customerLinkedList.remove(index);
            }
        }
    }
}