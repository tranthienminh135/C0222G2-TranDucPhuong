package phuong.case_study.furama_manager.model.contract;

public class Contract {
    private String contractId;
    private String bookingId;
    private long deposits;
    private long totalMoney;
    private String customerId;

    public Contract() {
    }

    public Contract(String contractId, String bookingId, long deposits, long totalMoney, String customerId) {
        this.contractId = contractId;
        this.bookingId = bookingId;
        this.deposits = deposits;
        this.totalMoney = totalMoney;
        this.customerId = customerId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public long getDeposits() {
        return deposits;
    }

    public void setDeposits(long deposits) {
        this.deposits = deposits;
    }

    public long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Contract {" +
                "contractId = '" + contractId + '\'' +
                ", bookingId = '" + bookingId + '\'' +
                ", deposits = " + deposits +
                ", totalMoney = " + totalMoney +
                ", customerId = '" + customerId + '\'' +
                '}';
    }
}
