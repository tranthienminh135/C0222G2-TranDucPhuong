package phuong.homework.model;

import java.util.Scanner;

public class Motorcycle extends Vehicle {
    private int wattage;

    public Motorcycle() {
    }

    public Motorcycle(int wattage) {
        this.wattage = wattage;
    }

    public Motorcycle(String licensePlate, Manufacturer manufacturer, int manufacturerYear, String owner, int wattage) {
        super(licensePlate, manufacturer, manufacturerYear, owner);
        this.wattage = wattage;
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.print("Enter wattage (HP): ");
        this.wattage = Integer.parseInt(sc.nextLine());
    }

    @Override
    public String toString() {
        return "Motorcycle {" +
                super.toString() +
                ", Wattage = " + wattage + "(HP) " +
                '}';
    }
}
