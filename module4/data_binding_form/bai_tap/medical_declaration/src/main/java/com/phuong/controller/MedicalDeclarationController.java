package com.phuong.controller;

import com.phuong.model.MedicalDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalDeclarationController {

    @GetMapping("/home")
    public String showFormMedical(Model model) {
        model.addAttribute("medicalDeclaration", new MedicalDeclaration());
        return "home";
    }

    @PostMapping("/save")
    public String saveMedical(@ModelAttribute MedicalDeclaration medicalDeclaration, Model model) {
        model.addAttribute("medicalDeclarationResult", medicalDeclaration);
        return "home";
    }
}
