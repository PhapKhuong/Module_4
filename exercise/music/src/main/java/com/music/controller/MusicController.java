package com.music.controller;

import com.music.model.MusicType;
import com.music.model.Song;
import com.music.service.itf.IMusicTypeService;
import com.music.service.itf.ISongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    private IMusicTypeService musicTypeService;
    private ISongService songService;

    private MusicController(IMusicTypeService musicTypeService, ISongService songService) {
        this.musicTypeService = musicTypeService;
        this.songService = songService;
    }

    @ModelAttribute("songs")
    public List<Song> getSongList() {
        return songService.showList();
    }

    @ModelAttribute("musicTypes")
    public List<MusicType> getMusicTypeList() {
        return musicTypeService.showList();
    }

    @GetMapping("/list")
    public String displayAllSong() {
        return "/list";
    }

    @GetMapping("/add")
    public ModelAndView addSong() {
        Song song = new Song();
        ModelAndView mv = new ModelAndView("/add");
        mv.addObject("song", song);
        return mv;
    }

    @PostMapping("/add")
    public String upload(@ModelAttribute Song song) {
        songService.add(song);
        return "redirect:/list";
    }
}
