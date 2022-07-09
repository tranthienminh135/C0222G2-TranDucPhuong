package com.phuong.service.contract.impl;

import com.phuong.model.contract.Contract;
import com.phuong.repository.contract.IContractRepository;
import com.phuong.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<Contract> getAllContract(Pageable pageable, String startDate, String endDate) {
        return this.contractRepository.getAllContract(pageable, startDate, endDate);
    }
}
