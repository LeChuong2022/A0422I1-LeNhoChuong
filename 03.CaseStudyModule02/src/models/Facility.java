package models;

public abstract class Facility {
    private String idFacility;
    private String nameOfService;
    private double areaUsed;
    private long rentalPrice;
    private int maxPeople;
    private String typeRental;

    public Facility(){
    }

    public Facility(String idFacility, String nameOfService, double areaUsed, long rentalPrice, int maxPeople, String typeRental) {
        this.idFacility = idFacility;
        this.nameOfService = nameOfService;
        this.areaUsed = areaUsed;
        this.rentalPrice = rentalPrice;
        this.maxPeople = maxPeople;
        this.typeRental = typeRental;
    }

    public String getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(String idFacility) {
        this.idFacility = idFacility;
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    public double getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(double areaUsed) {
        this.areaUsed = areaUsed;
    }

    public long getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(long rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public void setTypeRental(String typeRental) {
        this.typeRental = typeRental;
    }

    public abstract String getTypeRental();

    @Override
    public String toString() {
        return
                "idFacility='" + idFacility + '\'' +
                ", nameOfService='" + nameOfService + '\'' +
                ", areaUsed=" + areaUsed +
                ", rentalPrice=" + rentalPrice +
                ", maxPeople=" + maxPeople +
                ", typeRental='" + typeRental + '\'' ;
    }
}
