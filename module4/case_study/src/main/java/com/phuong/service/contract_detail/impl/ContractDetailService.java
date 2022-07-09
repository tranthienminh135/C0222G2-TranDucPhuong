package com.phuong.service.contract_detail.impl;

import com.phuong.model.contract.ContractDetail;
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
}
