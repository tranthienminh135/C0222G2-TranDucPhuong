package phuong.case_study.furama_manager.model;

public abstract class FurumaRentalService {
    private String serviceName;
    private double usableArea;
    private double rentalCosts;
    private int maximumNumberOfPeople;
    private String rentalType;

    public FurumaRentalService() {
    }

    /**
     * serviceName: Tên dịch vụ.
     * usableArea: Diện tích sử dụng.
     * rentalCosts: Chi phí thuê.
     * maximumNumberOfPeople: Số lượng người tối đa.
     * rentalType: Kiểu thuê.
     */
    public FurumaRentalService(String serviceName, double usableArea, double rentalCosts, int maximumNumberOfPeople, String rentalType) {
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.maximumNumberOfPeople = maximumNumberOfPeople;
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

    public int getMaximumNumberOfPeople() {
        return maximumNumberOfPeople;
    }

    public void setMaximumNumberOfPeople(int maximumNumberOfPeople) {
        this.maximumNumberOfPeople = maximumNumberOfPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "FurumaService{" +
                "serviceName='" + serviceName + '\'' +
                ", usableArea=" + usableArea +
                ", rentalCosts=" + rentalCosts +
                ", maximumNumberOfPeople=" + maximumNumberOfPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
