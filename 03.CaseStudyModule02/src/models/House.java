package models;

public class House extends Facility{
    public String standardRoom;
    public int floor;

    public House(){}

    public House(String idFacility, String nameOfService, double areaUsed, long rentalPrice, int maxPeople, String typeRental, String standardRoom, int floor) {
        super(idFacility, nameOfService, areaUsed, rentalPrice, maxPeople, typeRental);
        this.standardRoom = standardRoom;
        this.floor = floor;
    }

    @Override
    public String getTypeRental(){

        return null;
    }
}
