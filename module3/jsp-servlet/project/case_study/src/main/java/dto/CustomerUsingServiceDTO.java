package dto;

public class CustomerUsingServiceDTO {
    private int customerId;
    private String customerName;
    private String customerPhone;
    private String attachServiceName;

    public CustomerUsingServiceDTO(int customerId, String customerName, String customerPhone, String attachServiceName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.attachServiceName = attachServiceName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    @Override
    public String toString() {
        return "CustomerUsingServiceDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", attachServiceName='" + attachServiceName + '\'' +
                '}';
    }
}
