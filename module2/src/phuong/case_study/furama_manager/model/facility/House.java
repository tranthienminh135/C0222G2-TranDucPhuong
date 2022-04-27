package phuong.case_study.furama_manager.model.facility;

public class House extends Facility {
    private String roomStandard;
    private int floorsNumber;

    public House() {
    }

    public House(String roomStandard, int floorsNumber) {
        this.roomStandard = roomStandard;
        this.floorsNumber = floorsNumber;
    }

    public House(String serviceName, double usableArea, double rentalCosts, int maximumPeople, String rentalType, String serviceId, String roomStandard, int floorsNumber) {
        super(serviceName, usableArea, rentalCosts, maximumPeople, rentalType, serviceId);
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
    public String toString() {
        return "House {" +
                super.toString() +
                ", roomStandard = '" + roomStandard + '\'' +
                ", floorsNumber = " + floorsNumber +
                '}';
    }
}
