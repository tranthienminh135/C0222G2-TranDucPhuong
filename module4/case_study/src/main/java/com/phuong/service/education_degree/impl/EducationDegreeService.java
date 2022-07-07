package com.phuong.service.education_degree.impl;

import com.phuong.model.employee.EducationDegree;
import com.phuong.repository.education_degree.IEducationDegreeRepository;
import com.phuong.service.education_degree.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return this.educationDegreeRepository.findAll();
    }
}
