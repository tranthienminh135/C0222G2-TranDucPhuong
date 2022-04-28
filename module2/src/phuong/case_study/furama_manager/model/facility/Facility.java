package phuong.case_study.furama_manager.model.facility;

import java.util.Objects;

public abstract class Facility {
    private final static String COMMA = ",";
    private String serviceName;
    private double usableArea;
    private double rentalCosts;
    private int maximumPeople;
    private String rentalType;
    private String serviceId;

    public Facility() {
    }

    public Facility(String serviceName, double usableArea, double rentalCosts, int maximumPeople, String rentalType, String serviceId) {
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.maximumPeople = maximumPeople;
        this.rentalType = rentalType;
        this.serviceId = serviceId;
    }

    /**
     * serviceName: Tên dịch vụ.
     * usableArea: Diện tích sử dụng.
     * rentalCosts: Chi phí thuê.
     * maximumNumberOfPeople: Số lượng người tối đa.
     * rentalType: Kiểu thuê.
     */


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

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
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
        return Objects.hash(serviceName, usableArea, rentalCosts, maximumPeople, rentalType);
    }

    public String convertLine() {
        String line = this.serviceName + COMMA + this.usableArea + COMMA + this.rentalCosts + COMMA + this.maximumPeople + COMMA + this.rentalType + COMMA + this.serviceId;
        return line;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceName='" + serviceName + '\'' +
                ", usableArea=" + usableArea +
                ", rentalCosts=" + rentalCosts +
                ", maximumPeople=" + maximumPeople +
                ", rentalType='" + rentalType + '\'' +
                ", serviceId='" + serviceId + '\'' +
                '}';
    }
}
