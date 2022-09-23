package ss00_case_study.furama_resort.models;

public class Villa extends Facility{
    private String standardRooms;
    private int numberFloors;
    private double areOfPool;

    public Villa(){}

    public Villa(String standardRooms, int numberFloors, double areOfPool) {
        this.standardRooms = standardRooms;
        this.numberFloors = numberFloors;
        this.areOfPool = areOfPool;
    }

    public Villa(String idFacility, String nameFacility, double areaUse, double rentalCosts, int maxNumberOfPeople, String typeRent, String standardRooms, int numberFloors, double areOfPool) {
        super(idFacility, nameFacility, areaUse, rentalCosts, maxNumberOfPeople, typeRent);
        this.standardRooms = standardRooms;
        this.numberFloors = numberFloors;
        this.areOfPool = areOfPool;
    }

    public String getStandardRooms() {
        return standardRooms;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public double getAreOfPool() {
        return areOfPool;
    }

    public void setStandardRooms(String standardRooms) {
        this.standardRooms = standardRooms;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    public void setAreOfPool(double areOfPool) {
        this.areOfPool = areOfPool;
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() +
                "standardRooms='" + standardRooms + '\'' +
                ", numberFloors=" + numberFloors +
                ", areOfPool=" + areOfPool +
                '}';
    }
}
