package com.examination.service;

import com.examination.model.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();

    void save(Contract contract);

    void delete(String contractCode);

    Contract findById(String contractCode);
}
