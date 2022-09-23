package models;

public class Room extends Facility {
    public String freeService;

    public Room() {
    }

    public Room(String idFacility, String nameOfService, double areaUsed, long rentalPrice, int maxPeople, String typeRental, String freeService) {
        super(idFacility, nameOfService, areaUsed, rentalPrice, maxPeople, typeRental);
        this.freeService = freeService;
    }

    public String getTypeRental() {

        return null;
    }
}
