package com.phuong.service.contract_detail.impl;

import com.phuong.model.contract.ContractDetail;
import com.phuong.model.contract.ContractDetailDto;
import com.phuong.repository.contract_detail.IContractDetailRepository;
import com.phuong.service.contract_detail.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return this.contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        this.contractDetailRepository.save(contractDetail);
    }

    @Override
    public void updateQuantity(Integer quantity, Integer contractId, Integer attachFacilityId) {
        this.contractDetailRepository.updateQuantity(quantity, contractId, attachFacilityId);
    }
}
