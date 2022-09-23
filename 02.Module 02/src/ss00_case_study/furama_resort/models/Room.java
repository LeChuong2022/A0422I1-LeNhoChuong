package ss00_case_study.furama_resort.models;

public class Room extends Facility{
   private String freeService;

   public Room(){}

   public Room(String freeService) {
      this.freeService = freeService;
   }

   public Room(String idFacility, String nameFacility, double areaUse, double rentalCosts, int maxNumberOfPeople, String typeRent, String freeService) {
      super(idFacility, nameFacility, areaUse, rentalCosts, maxNumberOfPeople, typeRent);
      this.freeService = freeService;
   }

   public String getFreeService() {
      return freeService;
   }

   public void setFreeService(String freeService) {
      this.freeService = freeService;
   }

   @Override
   public String toString() {
      return "Room{" + super.toString() +
              "freeService='" + freeService + '\'' +
              '}';
   }
}
