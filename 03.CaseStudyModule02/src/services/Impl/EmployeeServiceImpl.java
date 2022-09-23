package services.Impl;

import exception.UserException;
import models.Customer;
import models.Employee;
import models.Person;
import services.EmployeeService;
import utils.ReadAndWrite;
import utils.RegexData;
import validate.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {

    private static List<Employee> employeeArrayList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private static final String BIRTHDAY_REGEX = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

    static {
        Date dayOfBirthEmployee1 = null;
        Date dayOfBirthEmployee2 = null;
        Date dayOfBirthEmployee3 = null;
        try {
            dayOfBirthEmployee1 = Validator.validateDayOfBirth("1/2/1985");
            dayOfBirthEmployee2 = Validator.validateDayOfBirth("2/2/1986");
            dayOfBirthEmployee3 = Validator.validateDayOfBirth("4/2/1991");
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
        Employee e1 = new Employee(1, "Nguyen Van A", dayOfBirthEmployee1, "male", 203436987, "0934621859", "nguyenvana@gmail.com", "Dai hoc", "Le tan", 500);
        Employee e2 = new Employee(2, "Nguyen Thi B", dayOfBirthEmployee2, "female", 205436987, "098613859", "nguyenthib@gmail.com", "Trung cap", "Le tan", 300);
        Employee e3 = new Employee(2, "Nguyen Thi C", dayOfBirthEmployee3, "female", 205454987, "0912536469", "nguyenthic@gmail.com", "Trung cap", "Le tan", 300);
        employeeArrayList.add(e1);
        employeeArrayList.add(e2);
        employeeArrayList.add(e3);
    }

    public void displayEmployeeList() {
       /* System.out.println("\n--------Employee List--------");
        int id = 0;
        for (Employee employee : employeeArrayList) {
            employee.setId(++id);
            System.out.println(employee.toString());
        }

        */
    }

    public void addEmployee(Employee e) {
        employeeArrayList.add(e);
    }

    public void editEmployee(int id, Employee e) {
        employeeArrayList.set(id - 1, e);
    }
////////////////lam tiep tu day


    public Employee enterInformation() {
        String option = "employee";
        System.out.print("Id of " + option + ": ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Name of " + option + ": ");
        String name = scanner.nextLine();

        System.out.print("Employee's day of birth': ");
        String strDayOfBirth = RegexData.regexAge(scanner.nextLine(), BIRTHDAY_REGEX);

        Date dayOfBirth = null;
        do {
            try {
                dayOfBirth = Validator.validateDayOfBirth(strDayOfBirth);
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

        System.out.print("Degree of employee: ");
        String degreeOfEmployee = scanner.nextLine();

        System.out.print("Position of employee: ");
        String positionOfEmployee = scanner.nextLine();

        System.out.print("Salary of employee: ");
        int salary = scanner.nextInt();

        Employee employee = new Employee(id, name, dayOfBirth, gender, identityCardNumber, phoneNumber, email, degreeOfEmployee, positionOfEmployee, salary);

        return employee;
    }

    @Override
    public void display() {
        employeeArrayList = (List<Employee>) ReadAndWrite.read("D:\\07.Code\\01.A0422i1\\03.CaseStudyModule02\\src\\data\\employee.csv");
        System.out.println("\n--------Employee List--------");
        for (Employee employee : employeeArrayList) {
            System.out.println(employee.toString());
        }
    }

    @Override
    public void addNew() {
        System.out.println("\nAdd new employee: ");
        Employee employee = enterInformation();
        employeeArrayList.add(employee);
        System.out.println("Finish add employee \n-----------");
        ReadAndWrite.write(employeeArrayList, "D:\\07.Code\\01.A0422i1\\03.CaseStudyModule02\\src\\data\\employee.csv");
    }

    @Override
    public void edit() {
        System.out.println("\nEdit employee: ");
        System.out.print("Select the id that you want to edit: ");
        int id = scanner.nextInt();

        Employee employee = enterInformation();
        employeeArrayList.set(id - 1, employee);
        System.out.println("Finish edit employee \n-----------");


    }

    @Override
    public void delete() {

    }
}
