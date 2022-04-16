package phuong.case_study.furama_manager.model;

public class Villa extends FurumaRentalService {
    private String roomStandard;
    private double swimmingPoolArea;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String roomStandard, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    /**
     * roomStandard: Tiêu chuẩn phòng
     * swimmingPoolArea: Diện tích hồ bơi
     * numberOfFloors: Chi phí thuê
     */
    public Villa(String roomStandard, double swimmingPoolArea, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(String serviceName, double usableArea, double rentalCosts, int maximumNumberOfPeople, String rentalType, String roomStandard, double swimmingPoolArea, int numberOfFloors) {
        super(serviceName, usableArea, rentalCosts, maximumNumberOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "roomStandard='" + roomStandard + '\'' +
                ", swimmingPoolArea=" + swimmingPoolArea +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
