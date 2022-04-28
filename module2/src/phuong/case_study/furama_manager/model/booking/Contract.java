package phuong.case_study.furama_manager.model.booking;

public class Contract {
    private final static String COMMA = ",";
    private String contractId;
    private String bookingId;
    private Long deposits;
    private Long totalMoney;
    private String customerId;

    public Contract() {
    }

    public Contract(String contractId, String bookingId, Long deposits, Long totalMoney, String customerId) {
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

    public Long getDeposits() {
        return deposits;
    }

    public void setDeposits(Long deposits) {
        this.deposits = deposits;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String convertLine() {
        String line = this.contractId + COMMA + this.bookingId + COMMA + this.deposits + COMMA + this.totalMoney + COMMA + this.customerId;
        return line;
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
