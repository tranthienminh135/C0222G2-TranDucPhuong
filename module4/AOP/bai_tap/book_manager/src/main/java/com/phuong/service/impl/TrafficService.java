package com.phuong.service.impl;

import com.phuong.model.Traffic;
import com.phuong.repository.ITrafficRepository;
import com.phuong.service.ITrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrafficService implements ITrafficService {
    @Autowired
    private ITrafficRepository trafficRepository;

    @Override
    public void increase() {
        List<Traffic> trafficList = this.trafficRepository.findAll();
        Traffic trafficTemp;
        if (trafficList.size() > 0) {
            Traffic traffic = this.trafficRepository.findById(1).orElse(null);
            trafficTemp = new Traffic(1, traffic.getQuantity() + 1);
        } else {
            trafficTemp = new Traffic();
            trafficTemp.setQuantity(1);
        }
        this.trafficRepository.save(trafficTemp);

    }

    @Override
    public int getById() {
        return this.trafficRepository.getById(1).getQuantity();
    }
}
