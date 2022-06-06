package model.customer;

public class CustomerType {
    private int customerTypeId;
    private String customerTypeName;
    private Integer status;

    public CustomerType() {
    }

    public CustomerType(int customerTypeId, String customerTypeName, Integer status) {
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
        this.status = status;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomerType{" +
                "customerTypeId=" + customerTypeId +
                ", customerTypeName='" + customerTypeName + '\'' +
                ", status=" + status +
                '}';
    }
}
