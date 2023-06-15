package com.mailbox.controller;

import com.mailbox.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mailbox")
public class MailboxController {
    @ModelAttribute("languages")
    private List<String> getLanguage() {
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        return languages;
    }

    @ModelAttribute("pageSizes")
    private List<Integer> getPageSize() {
        List<Integer> pageSizes = new ArrayList<>();
        pageSizes.add(5);
        pageSizes.add(10);
        pageSizes.add(15);
        pageSizes.add(25);
        pageSizes.add(50);
        pageSizes.add(100);
        return pageSizes;
    }

    @GetMapping("/setting")
    public ModelAndView doSet() {
        Setting setting = new Setting();
        ModelAndView mv = new ModelAndView("setting");
        mv.addObject("setting", setting);
        return mv;
    }

    @PostMapping("/setting")
    public String showMsg(@ModelAttribute Setting setting, Model model) {
        String msg = "Success " + setting;
        model.addAttribute("msg", msg);
        return "setting";
    }
}
