package com.phuong.model.contract;

import org.springframework.data.domain.Page;

import java.util.List;

public class ContractPageAndAttachFacilityListDto {
    private Page<Contract> contractPageDto;

    private List<AttachFacility> attachFacilityListDto;

    public ContractPageAndAttachFacilityListDto() {
    }

    public ContractPageAndAttachFacilityListDto(Page<Contract> contractPageDto, List<AttachFacility> attachFacilityListDto) {
        this.contractPageDto = contractPageDto;
        this.attachFacilityListDto = attachFacilityListDto;
    }

    public Page<Contract> getContractPageDto() {
        return contractPageDto;
    }

    public void setContractPageDto(Page<Contract> contractPageDto) {
        this.contractPageDto = contractPageDto;
    }

    public List<AttachFacility> getAttachFacilityListDto() {
        return attachFacilityListDto;
    }

    public void setAttachFacilityListDto(List<AttachFacility> attachFacilityListDto) {
        this.attachFacilityListDto = attachFacilityListDto;
    }
}
