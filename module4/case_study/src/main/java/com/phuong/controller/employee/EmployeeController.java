package com.phuong.controller.employee;

import com.phuong.model.employee.Division;
import com.phuong.model.employee.EducationDegree;
import com.phuong.model.employee.Position;
import com.phuong.service.division.IDivisionService;
import com.phuong.service.education_degree.IEducationDegreeService;
import com.phuong.service.position.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IPositionService positionService;

    @ModelAttribute("divisionList")
    public List<Division> getAllDivision() {
        return this.divisionService.findAll();
    }

    @ModelAttribute("educationDegreeList")
    public List<EducationDegree> getAllEducationDegree() {
        return this.educationDegreeService.findAll();
    }

    @ModelAttribute("positionList")
    public List<Position> getAllPosition() {
        return this.positionService.findAll();
    }

    @GetMapping("/employee")
    public String goEmployee() {
        return "employee/list";
    }
}
