package phuong.case_study.furama_manager.model.furuma;

import java.util.Objects;
import java.util.Scanner;

public abstract class Facility {
    private String serviceName;
    private double usableArea;
    private double rentalCosts;
    private int maximumPeople;
    private String rentalType;

    public Facility() {
    }

    /**
     * serviceName: Tên dịch vụ.
     * usableArea: Diện tích sử dụng.
     * rentalCosts: Chi phí thuê.
     * maximumNumberOfPeople: Số lượng người tối đa.
     * rentalType: Kiểu thuê.
     */
    public Facility(String serviceName, double usableArea, double rentalCosts, int maximumNumberPeople, String rentalType) {
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.maximumPeople = maximumNumberPeople;
        this.rentalType = rentalType;
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

    public int getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(int maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return Objects.equals(serviceName, facility.serviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceName);
    }

    @Override
    public String toString() {
        return ", serviceName = '" + serviceName + '\'' +
                ", usableArea = " + usableArea +
                ", rentalCosts = " + rentalCosts +
                ", maximumNumberOfPeople = " + maximumPeople +
                ", rentalType = '" + rentalType + '\'' +
                '}';
    }
}
