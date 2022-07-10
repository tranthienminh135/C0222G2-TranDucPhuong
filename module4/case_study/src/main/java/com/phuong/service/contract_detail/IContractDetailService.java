package com.phuong.service.contract_detail;

import com.phuong.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);

    void updateQuantity(Integer quantity, Integer contractId, Integer attachFacilityId);
}
