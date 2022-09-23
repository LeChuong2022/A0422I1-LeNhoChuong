package ss00_case_study.furama_resort.models;

public class House extends Facility{
    private String standardRooms;
    private int numberFloors;

    public House(){}

    public House(String standardRooms, int numberFloors) {
        this.standardRooms = standardRooms;
        this.numberFloors = numberFloors;
    }

    public House(String idFacility, String nameFacility, double areaUse, double rentalCosts, int maxNumberOfPeople, String typeRent, String standardRooms, int numberFloors) {
        super(idFacility, nameFacility, areaUse, rentalCosts, maxNumberOfPeople, typeRent);
        this.standardRooms = standardRooms;
        this.numberFloors = numberFloors;
    }

    public String getStandardRooms() {
        return standardRooms;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setStandardRooms(String standardRooms) {
        this.standardRooms = standardRooms;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "House{" + super.toString() +
                "standardRooms='" + standardRooms + '\'' +
                ", numberFloors=" + numberFloors +
                '}';
    }
}
