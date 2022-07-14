package com.examination.service.impl;

import com.examination.model.Contract;
import com.examination.repository.IContractRepository;
import com.examination.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        List<Contract> contractList = this.contractRepository.findAll();
        for (Contract contract: contractList) {
            switch (contract.getCostTime()) {
                case "3 Tháng":
                    contract.setTotalMoney(contract.getRoom().getPrice() * 3);
                    break;
                case "6 Tháng":
                    contract.setTotalMoney(contract.getRoom().getPrice() * 6);
                    break;
                case "12 Tháng":
                    contract.setTotalMoney(contract.getRoom().getPrice() * 12);
                    break;
                default:
                    contract.setTotalMoney(0.0);
                    break;
            }
        }
        return contractList;
    }

    @Override
    public void save(Contract contract) {
        this.contractRepository.save(contract);
    }

    @Override
    public void delete(String contractCode) {
        this.contractRepository.delete(this.contractRepository.findById(contractCode));
    }

    @Override
    public Contract findById(String contractCode) {
        return this.contractRepository.findById(contractCode);
    }
}
