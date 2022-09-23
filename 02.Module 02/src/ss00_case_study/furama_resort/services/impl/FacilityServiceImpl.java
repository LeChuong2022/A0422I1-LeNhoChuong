package ss00_case_study.furama_resort.services.impl;

import ss00_case_study.furama_resort.models.Facility;
import ss00_case_study.furama_resort.models.House;
import ss00_case_study.furama_resort.models.Room;
import ss00_case_study.furama_resort.models.Villa;
import ss00_case_study.furama_resort.services.FacilityService;
import ss00_case_study.furama_resort.utils.RegexData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {

    public static final String REGEX_STR = "[A-Z][a-z]+";
    public static final String REGEX_ID_VILLA = "SVVL[-][\\d]{4}";
    public static final String REGEX_ID_HOUSE = "SVHO[-][\\d]{4}";
    public static final String REGEX_ID_ROOM = "SVRO[-][\\d]{4}";
    public static final String REGEX_AMOUNT = "^[1-9]|([1][0-9])|(20)$";
    public static final String REGEX_INT = "^[1-9]|([1][0-9])$";
    public static final String REGEX_AREA = "^[3-9]\\d|[1-9]\\d{2,})$";
    public static final String REGEX_TYPE_RENT = "^DAY$|^MONTH$|^YEAR$";
    public static final String REGEX_STANDARD = "^STANDARD$|^DELUXE$|^SUITE$";


    static Map<Facility,Integer> facilityIntegerMap = new LinkedHashMap<>();
    static Scanner scanner = new Scanner(System.in);

    static {
        facilityIntegerMap.put(new Villa("1", "Villa1", 300, 1000,
                4, "Day", "Vip", 2, 200),0);
        facilityIntegerMap.put(new Villa("2", "Villa2", 400, 2000,
                5, "Day", "Normal", 3, 400),0);
    }

    private String inputIdVilla(){
        System.out.println("Enter id of villa: ");
        return RegexData.regexString(scanner.nextLine(),REGEX_ID_VILLA,"You entered wrong format, id of villa have format is SVVL-YYYY");
    }
    private String inputIdHouse(){
        System.out.println("Enter id of house: ");
        return RegexData.regexString(scanner.nextLine(),REGEX_ID_HOUSE,"You entered wrong format, id of house have format is SVHO-YYYY");
    }
    private String inputIdRoom(){
        System.out.println("Enter id of room: ");
        return RegexData.regexString(scanner.nextLine(),REGEX_ID_ROOM,"You entered wrong format, id of house have format is SVVL-YYYY");
    }

    private String inputName(){
        System.out.println("Enter name of facility: ");
        return RegexData.regexString(scanner.nextLine(),REGEX_STR,"You entered wrong format, id of facility have to write upper-case first letter");
    }

    private String inputArea(){
        System.out.println("Enter area of facility: ");
        return RegexData.regexString(scanner.nextLine(),REGEX_AREA,"You entered wrong format, area of facility must be greater than 30");
    }
    private String inputPrice(){
        System.out.println("Enter price of facility: ");
        return RegexData.regexString(scanner.nextLine(),REGEX_INT,"You entered wrong format, price must be positive number");
    }
    private String inputNumberOfPeople(){
        System.out.println("Enter number of people: ");
        return RegexData.regexString(scanner.nextLine(),REGEX_AMOUNT,"You entered wrong format, max number of people must be greater than 0 and less than 20");
    }

    private String inputNumberOfFloors(){
        System.out.println("Enter number of floors: ");
        return RegexData.regexString(scanner.nextLine(),REGEX_INT,"You entered wrong format, price must be integer");
    }

    private String inputAreaOfPool(){
        System.out.println("Enter area of pool: ");
        return RegexData.regexString(scanner.nextLine(),REGEX_AREA,"You entered wrong format, area of pool must be greater than 30");
    }

    private String inputTypeRent(){
        System.out.println("Enter type rent: ");
        return RegexData.regexString(scanner.nextLine(),REGEX_TYPE_RENT,"You entered wrong format, type rent must be DAY or MONTH or YEAR");
    }

    private String inputStandard(){
        System.out.println("Enter standard: ");
        return RegexData.regexString(scanner.nextLine(),REGEX_STANDARD,"You entered wrong format, type rent must be STANDARD or DELUXE or SUITE");
    }

    private String inputFreeService(){
        System.out.println("Enter free service: ");
        return RegexData.regexString(scanner.nextLine(),REGEX_STR,"You entered wrong format, free service have to write upper-case first letter");
    }


     @Override
    public void addNewVilla() {
        String id = inputIdVilla();
        String name = inputName();
        double areaUse = Double.parseDouble(inputArea());
        double price = Double.parseDouble(inputPrice());
        int numberPeoples = Integer.parseInt(inputNumberOfPeople());
        String type = inputTypeRent();
        String standard = inputStandard();
        int numberFloors = Integer.parseInt(inputNumberOfFloors());
        double areaPool = Double.parseDouble(inputAreaOfPool());

        Villa villa = new Villa(id,name,areaUse,price,numberPeoples,type,standard,numberFloors,areaPool);
        facilityIntegerMap.put(villa,0);
        System.out.println("Added new villa success");
    }

    @Override
    public void addNewHouse() {
        String id = inputIdHouse();
        String name = inputName();
        double areaUse = Double.parseDouble(inputArea());
        double price = Double.parseDouble(inputPrice());
        int numberPeoples = Integer.parseInt(inputNumberOfPeople());
        String type = inputTypeRent();
        String standard = inputStandard();
        int numberFloors = Integer.parseInt(inputNumberOfFloors());

        House house = new House(id,name,areaUse,price,numberPeoples,type,standard,numberFloors);
        facilityIntegerMap.put(house,0);
        System.out.println("Added new house success");
    }

    @Override
    public void addNewRoom() {
        String id = inputIdRoom();
        String name = inputName();
        double areaUse = Double.parseDouble(inputArea());
        double price = Double.parseDouble(inputPrice());
        int numberPeoples = Integer.parseInt(inputNumberOfPeople());
        String type = inputTypeRent();
        String freeService = inputFreeService();

        Room room = new Room(id,name,areaUse,price,numberPeoples,type,freeService);
        facilityIntegerMap.put(room,0);
        System.out.println("Added new room success");
    }

    @Override
    public void displayMaintenanceList() {

    }

    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            System.out.println("Service " + element.getKey() + ", times for rent " + element.getValue());
        }
    }
}
