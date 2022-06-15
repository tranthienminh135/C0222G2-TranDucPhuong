package com.phuong.model;

public class Customer {
    private String customerId;
    private String customerName;
    private Integer customerAge;
    private Double customerPoint;

    public Customer() {
    }

    public Customer(String customerId, String customerName, Integer customerAge, Double customerPoint) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.customerPoint = customerPoint;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(Integer customerAge) {
        this.customerAge = customerAge;
    }

    public Double getCustomerPoint() {
        return customerPoint;
    }

    public void setCustomerPoint(Double customerPoint) {
        this.customerPoint = customerPoint;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAge=" + customerAge +
                ", customerPoint=" + customerPoint +
                '}';
    }
}
