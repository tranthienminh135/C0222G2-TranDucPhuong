package phuong.case_study.furama_manager.model.person;

import java.util.Date;

public class Customer extends Person {
    private final static String COMMA = ",";
    private String customerRank;
    private String address;

    public Customer() {
    }

    public Customer(String customerRank, String address) {
        this.customerRank = customerRank;
        this.address = address;
    }

    public Customer(String id, String name, Date date, String gender, Long idCard, Long phoneNumber, String mail, String customerRank, String address) {
        super(id, name, date, gender, idCard, phoneNumber, mail);
        this.customerRank = customerRank;
        this.address = address;
    }

    public String getCustomerRank() {
        return customerRank;
    }

    public void setCustomerRank(String customerRank) {
        this.customerRank = customerRank;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String convertLine() {
        return super.convertLine() + COMMA + this.customerRank + COMMA + this.address;
    }

    @Override
    public String toString() {
        return "Customer {" +
                super.toString() +
                ", customerRank = '" + customerRank + '\'' +
                ", address = '" + address + '\'' +
                '}';
    }
}
