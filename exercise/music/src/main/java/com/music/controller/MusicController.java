package com.music.controller;

import com.music.exception.MusicException;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/music")
public class MusicController {
    private IMusicTypeService musicTypeService;
    private ISongService songService;

    private MusicController(IMusicTypeService musicTypeService, ISongService songService) {
        this.musicTypeService = musicTypeService;
        this.songService = songService;
    }

    @ModelAttribute("songMap")
    public Map<Song, String> getSongList() {
        return songService.showList();
    }

    @ModelAttribute("musicTypes")
    public List<MusicType> getMusicTypeList() {
        return musicTypeService.showList();
    }

    @ModelAttribute("extensionList")
    public List<String> getExtensionList() {
        List<String> extensionList = new ArrayList<>();
        extensionList.add("mp3");
        extensionList.add("wav");
        extensionList.add("ogg");
        extensionList.add("mp4");
        return extensionList;
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
    public String upload(@ModelAttribute Song song, Model model) {
        try {
            MultipartFile file = song.getFile();
            String[] extensionArr = file.getContentType().split("/");
            String extension = extensionArr[extensionArr.length - 1];
            if (!getExtensionList().contains(extension)) {
                throw new MusicException();
            }
            songService.add(song);
            return "redirect:/music/list";
        } catch (MusicException e) {
            String msg = "File must have content type is '.mp3', '.wav', '.ogg' or 'mp4'!";
            model.addAttribute("error", msg);
            return "add";
        }
    }
}
