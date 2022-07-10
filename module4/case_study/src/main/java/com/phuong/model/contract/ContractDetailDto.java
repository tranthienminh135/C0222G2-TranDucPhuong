package com.phuong.model.contract;

public class ContractDetailDto {
    private Contract contract;

    private AttachFacility attachFacility;

    private Integer quantity;

    public ContractDetailDto() {
    }

    public ContractDetailDto(Contract contract, AttachFacility attachFacility, Integer quantity) {
        this.contract = contract;
        this.attachFacility = attachFacility;
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
