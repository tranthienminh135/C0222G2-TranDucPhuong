package com.phuong.controller;

import com.phuong.model.Music;
import com.phuong.model.MusicDto;
import com.phuong.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("/home")
    public String goHome(Model model){
        List<Music> musicList = this.musicService.findAll();
        model.addAttribute("musicList", musicList);
        return "home";
    }

    @GetMapping("/create")
    public String goCreate(Model model){
        model.addAttribute("music", new MusicDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("music") MusicDto musicDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        this.musicService.save(music);
        return "redirect:/music/home";
    }

    @GetMapping("/edit/{id}")
    public String goEdit(Model model, @PathVariable Integer id){
        Music music = this.musicService.getById(id);
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(music, musicDto);
        model.addAttribute("music", musicDto);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("music") MusicDto musicDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        this.musicService.save(music);
        return "redirect:/music/home";
    }
}
