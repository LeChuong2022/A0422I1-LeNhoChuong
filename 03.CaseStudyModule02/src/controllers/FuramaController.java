package controllers;

import models.Contract;
import services.Impl.*;

import java.util.Scanner;



public class FuramaController {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        //Create EmployeeServiceImpl object
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        //Create CustomerServiceImpl object
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        //Create FacilityServiceImpl object
        FacilityServiceImpl facilityService = new FacilityServiceImpl();

        int choice = 0;
        do {
            displayMainManagement();
            System.out.print("Enter your option: ");
            choice = chooseOption();
            switch (choice) {
                case 1:
                    choiceEmployeeManagement(employeeService);
                    break;
                case 2:
                    choiceCustomerManagement(customerService);
                    break;
                case 3:
                    choiceFacilityManagement(facilityService);
                    break;
                case 4:
                    choiceBookingManagement();
                    break;
                case 5:
                    displayPromotionManagement();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter your choice between 1 and 6");
            }
        }
        while (choice != 6);

    }

    public static int chooseOption() {
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            System.out.println("You entered wrong format");
        }
        return choice;
    }

/*    public static Person enterInformationOfPerson(String option, Person person) {

        System.out.print("Id of " + option + ": ");
        int id = input.nextInt();

        input.nextLine(); // xóa bộ nhớ đệm
        System.out.print("Name of " + option + ": ");
        String name = input.nextLine();

        Date dayOfBirth = null;
        do {
            if (option.equals("employee"))
                System.out.print("Employee's day of birth': ");
            else
                System.out.print("Customer's day of birth': ");
            try {
                dayOfBirth = Validator.validateDayOfBirth(input.nextLine());
                break;
            } catch (UserException e) {
                e.printStackTrace();
            }
        } while (true);

        System.out.print("Gender of " + option + ": ");
        String gender = input.nextLine();

        System.out.print("Identity Card Number of " + option + ": ");
        int identityCardNumber = input.nextInt();

        input.nextLine(); // xóa bộ nhớ đệm
        System.out.print("Phone's number of " + option + ": ");
        String phoneNumber = input.nextLine();

        System.out.print("Email of " + option + ": ");
        String email = input.nextLine();

        if (option.equals("employee"))
            person = new Employee(id, name, dayOfBirth, gender, identityCardNumber, phoneNumber, email);
        else
            person = new Customer(id, name, dayOfBirth, gender, identityCardNumber, phoneNumber, email);

        return person;

    }

 */

    public static void displayMainManagement() {
        System.out.println("\nMenu: ");
        System.out.println("\t1. Employee Management");
        System.out.println("\t2. Customer Management");
        System.out.println("\t3. Facility Management");
        System.out.println("\t4. Booking Management");
        System.out.println("\t5. Promotion Management");
        System.out.println("\t6. Exit");
    }

    //Employee Management:
    public static void choiceEmployeeManagement(EmployeeServiceImpl employee) {
        int choice;
        do {
            displayEmployeeManagement();
            System.out.print("Enter your option: ");
            choice = chooseOption();
            switch (choice) {
                case 1:
                    employee.display();
                    break;
                case 2:
                    employee.addNew();
                    break;
                case 3:
                    employee.edit();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Please enter your choice between 1 and 4");
            }
        }
        while (choice != 4);
    }

    //Employee Management Case 1:
    public static void displayEmployeeManagement() {
        System.out.println("\n\t1. Display list employee");
        System.out.println("\t2. Add new employee");
        System.out.println("\t3. Edit employee");
        System.out.println("\t4. Return main menu");
    }

    //Employee Management Case 2 & 3:
/*    public static Employee addAndEditEmployee(String option) {
//
        Employee employee = new Employee();
        Person person = new Employee();
        person = enterInformationOfPerson(option, person);

       System.out.print("Degree of employee: ");
        String degreeOfEmployee = input.nextLine();

        System.out.print("Position of employee: ");
        String positionOfEmployee = input.nextLine();

        System.out.print("Salary of employee: ");
        int salary = input.nextInt();

        if (employee instanceof Person) {
            employee = (Employee) person;
            employee.setDegreeOfEmployee(degreeOfEmployee);
            employee.setPotionOfEmployee(positionOfEmployee);
            employee.setSalary(salary);
        }

        return employee;
    }
    */

    //Employee Management:
    public static void choiceCustomerManagement(CustomerServiceImpl customer) {
        int choice;
        do {
            displayCustomerManagement();
            System.out.print("Enter your option: ");
            choice = chooseOption();
            switch (choice) {
                case 1:
                    customer.displayCustomerList();
                    break;
                case 2:
                    customer.addNew();
                    break;
                case 3:
                    customer.edit();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Please enter your choice between 1 and 4");
            }
        }
        while (choice != 4);
    }

    //Customer Management Case 1:
    public static void displayCustomerManagement() {
        System.out.println("\n\t1. Display list customer");
        System.out.println("\t2. Add new customer");
        System.out.println("\t3. Edit customer");
        System.out.println("\t4. Return main menu");
    }

/*    //Customer Management Case 2 & 3:
    public static Customer addAndEditCustomer(String option) {
//
        Customer customer = new Customer();
        Person person = new Customer();
        person = enterInformationOfPerson(option, person);

        System.out.print("Type of customer: ");
        String typeOfCustomer = input.nextLine();

        System.out.print("Address of customer: ");
        String addressOfCustomer = input.nextLine();

        if (customer instanceof Person) {
            customer = (Customer) person;
            customer.setTypeOfCustomer(typeOfCustomer);
            customer.setAddressOfCustomer(addressOfCustomer);
        }
        return customer;
    }

 */

    //Employee Management:
    public static void choiceFacilityManagement(FacilityServiceImpl facility) {
        int choice;
        do {
            displayFacilityManagement();
            System.out.print("Enter your option: ");
            choice = chooseOption();
            switch (choice) {
                case 1:
                    facility.display();
                    break;
                case 2:
                    addNewFacilityManagement(facility);
                    break;
                case 3:
                    System.out.println("\n3Display list facility maintenance: ");
//                    System.out.print("Select the id that you want to edit: ");
//                    int id = input.nextInt();
//                    facility.editCustomer(id, addAndEditCustomer("customer"));
//                    System.out.println("Finish edit customer \n-----------");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Please enter your choice between 1 and 4");
            }
        }
        while (choice != 4);
    }

    public static void displayFacilityManagement() {
        System.out.println("\n\t1. Display list facility");
        System.out.println("\t2. Add new facility");
        System.out.println("\t3. Edit facility");
        System.out.println("\t4. Return main menu");
    }

    public static void addNewFacilityManagement(FacilityServiceImpl facility){
        int choice;
        do {
            displayAddNewFacilityManagement();
            System.out.print("Enter your option: ");
            choice = chooseOption();
            switch (choice) {
                case 1:
                    facility.addNewVilla();
                    break;
                case 2:
                    facility.addNewHouse();
                    break;
                case 3:
                    facility.addNewRoom();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Please enter your choice between 1 and 4");
            }
        }
        while (choice != 4);

    }

    public static void displayAddNewFacilityManagement(){
        System.out.println("\n\t1. Add New Villa");
        System.out.println("\t2. Add New House");
        System.out.println("\t3. Add New Room");
        System.out.println("\t4. Return main menu");
    }

    public static void choiceBookingManagement() {
        int choice;
        BookingServiceImpl bookingService = new BookingServiceImpl();
        ContractServiceImpl contractService = new ContractServiceImpl();
        do {
            displayBookingManagement();
            System.out.print("Enter your option: ");
            choice = chooseOption();
            switch (choice) {
                case 1:
                    bookingService.addBooking();
                    break;
                case 2:
                    bookingService.displayListBooking();
                    break;
                case 3:
                    contractService.createNewContract();
                    break;
                case 4:
                    contractService.displayListContract();
                    break;
                case 5:
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Please enter your choice between 1 and 6");
            }
        }
        while (choice != 6);
    }

    public static void displayBookingManagement() {
        System.out.println("\n\t1. Add new booking");
        System.out.println("\t2. Display list booking");
        System.out.println("\t3. Create new contracts");
        System.out.println("\t4. Display list contracts");
        System.out.println("\t5. Edit contracts");
        System.out.println("\t6. Return main menu");

    }

    public static void displayPromotionManagement() {
        System.out.println("\n\t1. Display list customers use service");
        System.out.println("\t2. Display list customers get voucher");
        System.out.println("\t3. Return main menu");
        int choice;
        do {
            System.out.print("Enter your option: ");
            choice = chooseOption();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Please enter your choice between 1 and 3");
            }
        }
        while (choice != 3);
    }


}
