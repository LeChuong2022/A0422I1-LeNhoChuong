package services.Impl;

import exception.UserException;
import models.*;
import services.FacilityService;
import utils.RegexData;
import validate.Validator;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    public static final String REGEX_STR = "[A-Z][a-z]+";
    public static final String REGEX_ID_VILLA = "(SVVL)[-][\\d]{4}";
    public static final String REGEX_AMOUNT = "^[1-9]|([1][0-9])|(20)$";
    public static final String REGEX_INT = "^[1-9]|([1][0-9])$";
    public static final String REGEX_AREA = "^([3-9]\\d|[1-9]\\d{2,})$";


    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private Scanner scanner = new Scanner(System.in);

//    //    private static LinkedHashMap<String, Integer> service = new LinkedHashMap<>();
//    static {
//        facilityIntegerMap.put("Add New Villa", 0);
//        facilityIntegerMap.put("Add New House", 0);
//        facilityIntegerMap.put("Add New Room", 0);
//    }

//    public void displayFacilityService() {
//        System.out.println("\n--------Facility Service List--------");
//        Set<String> keySet = service.keySet();
//        for (String key : keySet) {
//            System.out.println(key + " \t\t" + service.get(key));
//        }
//    }

    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            System.out.println("Service " + element.getKey() + " number of rented: " + element.getValue());
        }
    }

    @Override
    public void displayMaintain() {

    }


    @Override
    public void addNewVilla() {
        System.out.println("\nAdd new villa: ");

        String option = "villa";

        String idFacility = inputId();

        String nameOfService = inputName();

        double areaUsed = Double.parseDouble(inputArea());

        long rentalPrice = Long.parseLong(inputTotalPay());

        System.out.print("max people in " + option + ": ");
        int maxPeople = Integer.parseInt(scanner.nextLine());

        System.out.print("Type rental of " + option + ": ");
        String typeRental = scanner.nextLine();

        System.out.print("Standard of villa: ");
        String standardRoom = scanner.nextLine();

        System.out.print("Area of pool: ");
        double areaOfPool = Double.parseDouble(scanner.nextLine());

        System.out.print("Number of floor: ");
        int floor = scanner.nextInt();

        Villa villa = new Villa(idFacility, nameOfService, areaUsed, rentalPrice, maxPeople, typeRental, standardRoom, areaOfPool, floor);
        facilityIntegerMap.put(villa, 0);

        System.out.println("Finish add new villa \n-----------");


    }

    @Override
    public void addNewHouse() {
        System.out.println("\nAdd new house: ");

        String option = "house";
        System.out.print("Id of " + option + ": ");
        String idFacility = scanner.nextLine();

        System.out.print("Name of service: ");
        String nameOfService = scanner.nextLine();

        System.out.print("area of " + option + ": ");
        double areaUsed = Double.parseDouble(scanner.nextLine());

        System.out.print("rental price of " + option + ": ");
        long rentalPrice = Long.parseLong(scanner.nextLine());

        System.out.print("max people in " + option + ": ");
        int maxPeople = Integer.parseInt(scanner.nextLine());

        System.out.print("Type rental of " + option + ": ");
        String typeRental = scanner.nextLine();

        System.out.print("Standard of villa: ");
        String standardRoom = scanner.nextLine();

        System.out.print("Number of floor: ");
        int floor = scanner.nextInt();

        House house = new House(idFacility, nameOfService, areaUsed, rentalPrice, maxPeople, typeRental, standardRoom, floor);
        facilityIntegerMap.put(house, 0);

        System.out.println("Finish add new house \n-----------");

    }

    private String inputId(){
        System.out.println("Enter id, service code: ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_ID_VILLA, "You entered wrong format, format of service code is SVVL-XXXX");
    }
    private String inputName(){
        System.out.println("Enter service name: ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_STR, "You entered wrong format, Service name must be capitalized");
    }
    private String inputArea(){
        System.out.println("Enter area: ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_AREA, "You entered wrong format, Area must be more than 30");
    }
    private String inputTotalPay(){
        System.out.println("Enter rental price: ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_INT, "You entered wrong format, Price must be positive");
    }

    //    String idFacility, String nameOfService, double areaUsed, long rentalPrice, int maxPeople, String typeRental, String freeService
    @Override
    public void addNewRoom() {
        System.out.println("\nAdd new room: ");

        String option = "room";
        System.out.print("Id of " + option + ": ");
        String idFacility = scanner.nextLine();

        System.out.print("Name of service: ");
        String nameOfService = scanner.nextLine();

        System.out.print("area of " + option + ": ");
        double areaUsed = Double.parseDouble(scanner.nextLine());

        System.out.print("rental price of " + option + ": ");
        long rentalPrice = Long.parseLong(scanner.nextLine());

        System.out.print("max people in " + option + ": ");
        int maxPeople = Integer.parseInt(scanner.nextLine());

        System.out.print("Type rental of " + option + ": ");
        String typeRental = scanner.nextLine();

        System.out.print("Free service: ");
        String freeService = scanner.nextLine();

        Room room = new Room(idFacility, nameOfService, areaUsed, rentalPrice, maxPeople, typeRental, freeService);
        facilityIntegerMap.put(room, 0);

        System.out.println("Finish add new room \n-----------");

    }


    //////////////////////

}
