package phuong.homework.model;

import java.util.Scanner;

public class Truck extends Vehicle{
    private int tonnage;

    public Truck() {
    }

    public Truck(int tonnage) {
        this.tonnage = tonnage;
    }

    public Truck(String licensePlate, Manufacturer manufacturer, int manufacturerYear, String owner, int tonnage) {
        super(licensePlate, manufacturer, manufacturerYear, owner);
        this.tonnage = tonnage;
    }

    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.print("Enter tonnage (T): ");
        this.tonnage = Integer.parseInt(sc.nextLine());
    }

    @Override
    public String toString() {
        return "Truck {" +
                super.toString() +
                ", Tonnage = " + tonnage + "(T)" +
                '}';
    }
}
