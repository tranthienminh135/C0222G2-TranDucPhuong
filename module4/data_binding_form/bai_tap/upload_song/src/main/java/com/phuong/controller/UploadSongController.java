package com.phuong.controller;

import com.phuong.model.UploadSong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UploadSongController {

    @GetMapping("/upload")
    public String showFormUpload(Model model) {
        model.addAttribute("uploadSong", new UploadSong());
        return "upload-form";
    }

    @PostMapping("/upload")
    public String upload(@ModelAttribute UploadSong uploadSong, Model model) {
        model.addAttribute("uploadSongResult", uploadSong);
        return "upload-form";
    }
}
