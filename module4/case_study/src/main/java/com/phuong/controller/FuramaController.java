package com.phuong.controller;

import com.phuong.model.facility.Facility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FuramaController {
    @GetMapping(value = {"/home", "/"})
    public String goHome(){
        return "homePage";
    }

    @GetMapping(value = "/facility")
    public String goFacility() {
        return "facility/list";
    }
    @GetMapping(value = "/facility/create")
    public String goCreateFacility(Model model) {
        model.addAttribute("facility", new Facility());
        return "facility/create";
    }

    @PostMapping(value = "/facility/create")
    public String saveCreateFacility(@ModelAttribute("facility") Facility facility) {
        System.out.println(facility.getPoolArea());
        return "facility/create";
    }
}
