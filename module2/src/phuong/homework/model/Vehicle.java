package phuong.homework.model;

import java.util.Scanner;

public abstract class Vehicle {
    private String licensePlate;
    private Manufacturer manufacturer;
    private int manufacturerYear;
    private String owner;

    public Vehicle() {
    }

    public Vehicle(String licensePlate, Manufacturer manufacturer, int manufacturerYear, String owner) {
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.manufacturerYear = manufacturerYear;
        this.owner = owner;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getManufacturerYear() {
        return manufacturerYear;
    }

    public void setManufacturerYear(int manufacturerYear) {
        this.manufacturerYear = manufacturerYear;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sea control: ");
        this.licensePlate = sc.nextLine();
        System.out.print("Enter manufacturer id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter manufacturer name: ");
        String name = sc.nextLine();
        System.out.print("Enter manufacturer nation: ");
        String nation = sc.nextLine();
        Manufacturer manufacturer = new Manufacturer(id,name,nation);
        this.manufacturer = manufacturer;
        System.out.print("Enter manufacturer year: ");
        this.manufacturerYear = Integer.parseInt(sc.nextLine());
        System.out.print("Enter owner: ");
        this.owner = sc.nextLine();
    }

    @Override
    public String toString() {
        return "License Plate = '" + licensePlate + '\'' +
                ", Manufacturer = '" + manufacturer + '\'' +
                ", ManufacturerYear = " + manufacturerYear +
                ", Owner = '" + owner + '\'';
    }
}
