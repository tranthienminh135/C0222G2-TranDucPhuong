package phuong.homework.model;

import java.util.ArrayList;
import java.util.List;
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
        this.manufacturer = this.choiceManufacturer();
        System.out.print("Enter manufacturer year: ");
        this.manufacturerYear = Integer.parseInt(sc.nextLine());
        System.out.print("Enter owner: ");
        this.owner = sc.nextLine();
    }

    public Manufacturer choiceManufacturer() {
        Scanner sc = new Scanner(System.in);
        List<Manufacturer> manufacturerList = new ArrayList<>();
        manufacturerList.add(new Manufacturer(1, "TOYOTA", "Japan"));
        manufacturerList.add(new Manufacturer(2, "CHEVROLET", "USA"));
        manufacturerList.add(new Manufacturer(3, "FUSO", "Japan"));
        manufacturerList.add(new Manufacturer(4, "DAEWOO", "Korea"));
        manufacturerList.add(new Manufacturer(5, "PIAGGIO", "Italy"));
        manufacturerList.add(new Manufacturer(6, "Harley Davidson", "USA"));

        System.out.println("---------- CHOICE MANUFACTURER ----------");
        int choice;
        do {
            for (int i = 0; i < manufacturerList.size(); i++) {
                System.out.println((i + 1) + ". " + manufacturerList.get(i).getName());
            }

            System.out.print("Your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            if (choice > 0 && choice < manufacturerList.size()) {
                return manufacturerList.get(choice - 1);
            } else {
                System.out.println("---------- CHOICE AGAIN! ----------");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return "License Plate = '" + licensePlate + '\'' +
                ", Manufacturer = '" + manufacturer + '\'' +
                ", ManufacturerYear = " + manufacturerYear +
                ", Owner = '" + owner + '\'';
    }
}
