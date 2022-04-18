package phuong.case_study.furama_manager.model.furuma;

import java.util.Scanner;

public class Room extends Furuma {
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
    public void input() {
        Scanner sc = new Scanner(System.in);
        super.input();
        this.freeService = sc.nextLine();
    }

    @Override
    public String toString() {
        return "Room {" +
                super.toString() +
                ", freeService = '" + freeService + '\'' +
                '}';
    }
}
