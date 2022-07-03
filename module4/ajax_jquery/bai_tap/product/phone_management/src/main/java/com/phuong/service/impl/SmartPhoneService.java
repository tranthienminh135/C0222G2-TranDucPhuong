package com.phuong.service.impl;

import com.phuong.model.Smartphone;
import com.phuong.repository.ISmartphoneRepository;
import com.phuong.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartPhoneService implements ISmartphoneService {
    @Autowired
    private ISmartphoneRepository smartPhoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Integer id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Integer id) {
        smartPhoneRepository.deleteById(id);
    }

    @Override
    public Page<Smartphone> getAllSmartphone(String searchParam, Pageable pageable) {
        return this.smartPhoneRepository.getAllSmartphone("%" + searchParam + "%", pageable);
    }
}
