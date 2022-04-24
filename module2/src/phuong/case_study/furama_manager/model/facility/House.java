package phuong.case_study.furama_manager.model.facility;

import java.util.Objects;

public class House extends Facility {
    private String roomStandard;
    private int floorsNumber;

    public House() {
    }

    public House(String roomStandard, int floorsNumber) {
        this.roomStandard = roomStandard;
        this.floorsNumber = floorsNumber;
    }

    public House(String serviceName, double usableArea, double rentalCosts, int maximumNumberPeople, String rentalType, String roomStandard, int floorsNumber) {
        super(serviceName, usableArea, rentalCosts, maximumNumberPeople, rentalType);
        this.roomStandard = roomStandard;
        this.floorsNumber = floorsNumber;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloorsNumber() {
        return floorsNumber;
    }

    public void setFloorsNumber(int floorsNumber) {
        this.floorsNumber = floorsNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        House house = (House) o;
        return floorsNumber == house.floorsNumber && Objects.equals(roomStandard, house.roomStandard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roomStandard, floorsNumber);
    }

    @Override
    public String toString() {
        return "House {" +
                super.toString() +
                ", roomStandard = '" + roomStandard + '\'' +
                ", floorsNumber = " + floorsNumber +
                '}';
    }
}
