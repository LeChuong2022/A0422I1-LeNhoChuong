package ss00_case_study.furama_resort.services.impl;

import ss00_case_study.furama_resort.exception.UserException;
import ss00_case_study.furama_resort.models.Employee;
import ss00_case_study.furama_resort.services.EmployeeService;
import ss00_case_study.furama_resort.utils.ReadAndWriteFile;
import ss00_case_study.furama_resort.validate.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employeeArrayList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    static {
        employeeArrayList.add(new Employee(1,"Hoang","10/03/1988",
                "Male","001H","0905117090","Hoang@gmail","Da Nang",
                "Dai hoc","Nhan vien",1000));
        employeeArrayList.add(new Employee(2,"Long","10/03/1988",
                "Male","001H","0905117090","Hoang@gmail","Da Nang",
                "Dai hoc","Nhan vien",1000));
        employeeArrayList.add(new Employee(3,"Nam","10/03/1988",
                "Male","001H","0905117090","Hoang@gmail","Da Nang",
                "Dai hoc","Nhan vien",1000));
        employeeArrayList.add(new Employee(4,"Dung","10/03/1988",
                "Male","001H","0905117090","Hoang@gmail","Da Nang",
                "Dai hoc","Nhan vien",1000));
    }
//"G:\\CODE GYM\\A0422I1\\MODULE 2.0\\src\\ss00_case_study\\furama_resort\\data\\employee.csv"
    @Override
    public void display() {
        employeeArrayList = (List<Employee>) ReadAndWriteFile.read("D:\\07.Code\\01.A0422i1\\02.Module 02\\src\\ss00_case_study\\furama_resort\\data\\employee.csv");
        for(Employee employee:employeeArrayList)
            System.out.println(employee.toString());
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
        System.out.println("Enter level of education: ");
        String educationLevel = scanner.nextLine();
        System.out.println("Enter position: ");
        String position = scanner.nextLine();
        System.out.println("Enter salary: ");
        int salary = Integer.parseInt(scanner.nextLine());
        Employee employee = new Employee(id,name,dateOfBirth,gender,idCard,phoneNumber,email,address,educationLevel,position,salary);
        employeeArrayList.add(employee);

        ReadAndWriteFile.write(employeeArrayList,"D:\\07.Code\\01.A0422i1\\02.Module 02\\src\\ss00_case_study\\furama_resort\\data\\employee.csv");

    }

    @Override
    public void edit() {
        System.out.println("Enter id of employee need edit");
        int id = Integer.parseInt(scanner.nextLine());
        for(Employee employee: employeeArrayList){
            if(id == employee.getId()){
                int index = employeeArrayList.indexOf(employee);

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
                System.out.println("Enter level of education: ");
                String educationLevel = scanner.nextLine();
                System.out.println("Enter position: ");
                String position = scanner.nextLine();
                System.out.println("Enter salary: ");
                int salary = Integer.parseInt(scanner.nextLine());
                Employee employeeEdit = new Employee(id,name,dateOfBirth,gender,idCard,phoneNumber,email,address,educationLevel,position,salary);
                employeeArrayList.set(index,employeeEdit);
            }
        }
        System.out.println("Edited customer success");
    }

    @Override
    public void delete() {
        System.out.println("Enter id of employee need delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Employee employee : employeeArrayList) {
            if (id == employee.getId()) {
                int index = employeeArrayList.indexOf(employee);
                employeeArrayList.remove(index);
            }
        }
    }
}