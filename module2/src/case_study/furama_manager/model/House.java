package case_study.furama_manager.model;

public class House extends Villa {
    public House() {
    }

    public House(String roomStandard, int numberOfFloors) {
        super(roomStandard, numberOfFloors);
    }

    @Override
    public String getRoomStandard() {
        return super.getRoomStandard();
    }

    @Override
    public void setRoomStandard(String roomStandard) {
        super.setRoomStandard(roomStandard);
    }

    @Override
    public int getNumberOfFloors() {
        return super.getNumberOfFloors();
    }

    @Override
    public void setNumberOfFloors(int numberOfFloors) {
        super.setNumberOfFloors(numberOfFloors);
    }
}
