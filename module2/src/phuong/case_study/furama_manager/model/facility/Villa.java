package phuong.case_study.furama_manager.model.facility;

import java.util.Objects;

public class Villa extends Facility {
    private String roomStandard;
    private Double swimmingPoolArea;
    private Integer floorsNumber;

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

    public Villa(String serviceName, double usableArea, double rentalCosts, int maximumNumberPeople, String rentalType, String roomStandard, Double swimmingPoolArea, Integer floorsNumber) {
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

    public Double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(Double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public Integer getFloorsNumber() {
        return floorsNumber;
    }

    public void setFloorsNumber(Integer floorsNumber) {
        this.floorsNumber = floorsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Villa villa = (Villa) o;
        return Objects.equals(roomStandard, villa.roomStandard) && Objects.equals(swimmingPoolArea, villa.swimmingPoolArea) && Objects.equals(floorsNumber, villa.floorsNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roomStandard, swimmingPoolArea, floorsNumber);
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
