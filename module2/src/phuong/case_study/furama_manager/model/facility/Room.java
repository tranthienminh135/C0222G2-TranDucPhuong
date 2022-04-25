package phuong.case_study.furama_manager.model.facility;

import java.util.Objects;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String serviceName, double usableArea, double rentalCosts, int maximumNumberPeople, String rentalType, String freeService) {
        super(serviceName, usableArea, rentalCosts, maximumNumberPeople, rentalType);
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
        return "Room {" +
                super.toString() +
                ", freeService = '" + freeService + '\'' +
                '}';
    }
}
