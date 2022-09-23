package models;

public class Villa extends Facility {
    public String standardRoom;
    public double areaOfPool;
    public int floor;

    public Villa() {
    }

    public Villa(String idFacility, String nameOfService, double areaUsed, long rentalPrice, int maxPeople, String typeRental, String standardRoom, double areaOfPool, int floor) {
        super(idFacility, nameOfService, areaUsed, rentalPrice, maxPeople, typeRental);
        this.standardRoom = standardRoom;
        this.areaOfPool = areaOfPool;
        this.floor = floor;
    }

    @Override
    public String getTypeRental() {

        return null;
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() +
                "standardRoom='" + standardRoom + '\'' +
                ", areaOfPool=" + areaOfPool +
                ", floor=" + floor +
                '}';
    }
}
