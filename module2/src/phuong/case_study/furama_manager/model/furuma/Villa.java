package phuong.case_study.furama_manager.model.furuma;

import java.util.Scanner;

public class Villa extends Furuma {
    private String roomStandard;
    private double swimmingPoolArea;
    private int floorsNumber;

    public Villa() {
    }

    public Villa(String roomStandard, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.floorsNumber = numberOfFloors;
    }

    /**
     * roomStandard: Tiêu chuẩn phòng
     * swimmingPoolArea: Diện tích hồ bơi
     * floorsNumber: Số tầng
     */
    public Villa(String roomStandard, double swimmingPoolArea, int floorsNumber) {
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.floorsNumber = floorsNumber;
    }

    public Villa(String serviceName, double usableArea, double rentalCosts, int maximumNumberPeople, String rentalType, String roomStandard, double swimmingPoolArea, int floorsNumber) {
        super(serviceName, usableArea, rentalCosts, maximumNumberPeople, rentalType);
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.floorsNumber = floorsNumber;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
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
        System.out.print("Ener swimming pool area: ");
        this.swimmingPoolArea = Double.parseDouble(sc.nextLine());
        System.out.print("Enter number of floors number: ");
        this.floorsNumber = Integer.parseInt(sc.nextLine());
    }

    @Override
    public String toString() {
        return "Villa {" +
                super.toString() +
                ", roomStandard = '" + roomStandard + '\'' +
                ", swimmingPoolArea = " + swimmingPoolArea +
                ", numberOfFloors = " + floorsNumber +
                '}';
    }
}
