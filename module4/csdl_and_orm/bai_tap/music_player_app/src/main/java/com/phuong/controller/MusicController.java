package com.phuong.controller;

import com.phuong.model.Music;
import com.phuong.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("")
    public String goHome(Model model){
        List<Music> musicList = musicService.getAllMusic();
        model.addAttribute("message", "");
        model.addAttribute("musicList", musicList);
        return "home";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("music", new Music());
        return "create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute Music music){
        musicService.save(music);
        return "redirect:/music/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        musicService.delete(id);
        return "redirect:/music/";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        Music music = musicService.findById(id);
        model.addAttribute("music", music);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit( @ModelAttribute Music music){
        musicService.update(music);
        return "redirect:/music/";
    }
}
