package phuong.case_study.furama_manager.model.furuma;

import java.util.Scanner;

public abstract class Furuma {
    private String serviceName;
    private double usableArea;
    private double rentalCosts;
    private int maximumNumberPeople;
    private String rentalType;

    public Furuma() {
    }

    /**
     * serviceName: Tên dịch vụ.
     * usableArea: Diện tích sử dụng.
     * rentalCosts: Chi phí thuê.
     * maximumNumberOfPeople: Số lượng người tối đa.
     * rentalType: Kiểu thuê.
     */
    public Furuma(String serviceName, double usableArea, double rentalCosts, int maximumNumberPeople, String rentalType) {
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.maximumNumberPeople = maximumNumberPeople;
        this.rentalType = rentalType;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter service name: ");
        this.serviceName = sc.nextLine();
        System.out.print("Enter usable area: ");
        this.usableArea = Double.parseDouble(sc.nextLine());
        System.out.print("Enter rental costs: ");
        this.rentalCosts = Double.parseDouble(sc.nextLine());
        System.out.print("Enter maximum number of people: ");
        this.maximumNumberPeople = Integer.parseInt(sc.nextLine());
        System.out.print("Enter rental type ");
        this.rentalType = sc.nextLine();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaximumNumberPeople() {
        return maximumNumberPeople;
    }

    public void setMaximumNumberPeople(int maximumNumberPeople) {
        this.maximumNumberPeople = maximumNumberPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return ", serviceName = '" + serviceName + '\'' +
                ", usableArea = " + usableArea +
                ", rentalCosts = " + rentalCosts +
                ", maximumNumberOfPeople = " + maximumNumberPeople +
                ", rentalType = '" + rentalType + '\'' +
                '}';
    }
}
