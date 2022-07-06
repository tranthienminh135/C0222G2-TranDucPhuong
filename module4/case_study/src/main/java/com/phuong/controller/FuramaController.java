package com.phuong.controller;

import com.phuong.model.facility.Facility;
import com.phuong.model.facility.FacilityType;
import com.phuong.model.facility.RentType;
import com.phuong.service.facility.IFacilityService;
import com.phuong.service.facility_type.IFacilityTypeService;
import com.phuong.service.rent_type.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class FuramaController {

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @ModelAttribute("facilityTypeList")
    public List<FacilityType> getAllFacilityType() {
        return this.facilityTypeService.findAll();
    }

    @ModelAttribute("rentTypeList")
    public List<RentType> getAllRentType() {
        return this.rentTypeService.findAll();
    }

    @GetMapping(value = {"/home", "/"})
    public String goHome(){
        return "homePage";
    }

    @GetMapping(value = "/facility")
    public String goFacility(@PageableDefault(value = 5) Pageable pageable, Model model, Optional<String> searchValue) {
        String searchParam = searchValue.orElse("");
        Page<Facility> facilityPage = this.facilityService.getAllFacility(pageable, searchParam);
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("searchParam", searchParam);
        return "facility/list";
    }

    @GetMapping(value = "/facility/create")
    public String goCreateFacility(Model model) {
        model.addAttribute("facility", new Facility());
        return "facility/create";
    }

    @PostMapping(value = "/facility/create")
    public String saveCreateFacility(@ModelAttribute("facility") Facility facility) {
        this.facilityService.save(facility);
        return "redirect:/facility";
    }

    @GetMapping(value = "/facility/edit/{idEdit}")
    public String goEditFacility(Model model, @PathVariable Integer idEdit) {
        Facility facility = this.facilityService.findById(idEdit);
        model.addAttribute("facility", facility);
        model.addAttribute("inputFacilityHidden", facility.getFacilityType().getName());
        return "facility/edit";
    }

    @PostMapping(value = "/facility/edit")
    public String saveEditFacility(@ModelAttribute("facility") Facility facility) {
        this.facilityService.save(facility);
        return "redirect:/facility";
    }

    @GetMapping(value = "/facility/delete/{idDelete}")
    public String deleteFacility(@PathVariable Integer idDelete) {
        this.facilityService.delete(idDelete);
        return "redirect:/facility";
    }
}
