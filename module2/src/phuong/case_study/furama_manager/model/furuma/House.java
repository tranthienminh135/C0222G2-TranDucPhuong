package phuong.case_study.furama_manager.model.furuma;

import java.util.Scanner;

public class House extends Furuma {
    private String roomStandard;
    private int floorsNumber;

    public House() {
    }

    public House(String roomStandard, int floorsNumber) {
        this.roomStandard = roomStandard;
        this.floorsNumber = floorsNumber;
    }

    public House(String serviceName, double usableArea, double rentalCosts, int maximumNumberPeople, String rentalType, String roomStandard, int floorsNumber) {
        super(serviceName, usableArea, rentalCosts, maximumNumberPeople, rentalType);
        this.roomStandard = roomStandard;
        this.floorsNumber = floorsNumber;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloorsNumber() {
        return floorsNumber;
    }

    public void setFloorsNumber(int floorsNumber) {
        this.floorsNumber = floorsNumber;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.print("Enter room standard: ");
        this.roomStandard = sc.nextLine();
        System.out.print("Enter room standard: ");
        this.floorsNumber = Integer.parseInt(sc.nextLine());
    }

    @Override
    public String toString() {
        return "House {" +
                super.toString() +
                ", roomStandard = '" + roomStandard + '\'' +
                ", floorsNumber = " + floorsNumber +
                '}';
    }
}
