package phuong.homework.model;

import java.util.Scanner;

public class Car extends Vehicle {
    private int seatsNumber;
    private String vehicleType;

    public Car() {
    }

    public Car(int seatsNumber, String vehicleType) {
        this.seatsNumber = seatsNumber;
        this.vehicleType = vehicleType;
    }

    public Car(String licensePlate, Manufacturer manufacturer, int manufacturerYear, String owner, int seatsNumber, String vehicleType) {
        super(licensePlate, manufacturer, manufacturerYear, owner);
        this.seatsNumber = seatsNumber;
        this.vehicleType = vehicleType;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.print("Enter seats number: ");
        this.seatsNumber = Integer.parseInt(sc.nextLine());
        System.out.print("Enter vehicle type: ");
        this.vehicleType = sc.nextLine();
    }

    @Override
    public String toString() {
        return "Car {" +
                super.toString() +
                ", SeatsNumber = " + seatsNumber +
                ", VehicleTyp = '" + vehicleType + '\'' +
                '}';
    }
}
