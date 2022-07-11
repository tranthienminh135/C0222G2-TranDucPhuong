package com.phuong.model.customer;

import com.phuong.model.contract.AttachFacility;

import java.util.List;

public class CustomerAndAttachFacilityDto {

    private Customer customer;

    private List<AttachFacility> attachFacilityList;

    public CustomerAndAttachFacilityDto() {
    }

    public CustomerAndAttachFacilityDto(Customer customer, List<AttachFacility> attachFacilityList) {
        this.customer = customer;
        this.attachFacilityList = attachFacilityList;
    }

    public CustomerAndAttachFacilityDto(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<AttachFacility> getAttachFacilityList() {
        return attachFacilityList;
    }

    public void setAttachFacilityList(List<AttachFacility> attachFacilityList) {
        this.attachFacilityList = attachFacilityList;
    }
}
