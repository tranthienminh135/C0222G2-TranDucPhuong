package com.phuong.repository;

import com.phuong.model.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrafficRepository extends JpaRepository<Traffic, Integer> {
}
