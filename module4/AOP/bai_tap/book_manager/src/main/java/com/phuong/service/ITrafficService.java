package com.phuong.service;

import com.phuong.model.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrafficService {
    void increase();

    int getById();
}
