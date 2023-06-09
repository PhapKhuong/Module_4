package com.dictionary.controller;

import com.dictionary.exception.DicException;
import com.dictionary.service.IDicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    private IDicService service;

    public DictionaryController(IDicService service) {
        this.service = service;
    }

    @GetMapping("/dictionary")
    public String showForm() {
        return "dictionary/input";
    }

    @PostMapping("/show-result")
    public String showResult(@RequestParam("choose") String choose, @RequestParam("word") String word,
                             Model model) {
        try {
            String str = null;
            if (choose.equals("ev")) {
                str = service.searchByE(word);
            } else {
                str = service.searchByV(word);
            }

            if (str == null) {
                throw new DicException();
            }

            String resultStr = "Nghia cua tu '" + word + "' la: " + str;
            model.addAttribute("mean", resultStr);
            return "dictionary/result";
        } catch (DicException e) {
            String msg = "Khong co tu nay";
            model.addAttribute("error", msg);
            return "dictionary/result";
        }
    }
}
