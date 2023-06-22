package com.declaration.controller;

import com.declaration.model.Declaration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/medical-declaration")
public class DeclarationController {
    @GetMapping(value = "", produces = "application/x-www-font-urlencoded;charset=UTF-8")
    public ModelAndView showPage() {
        ModelAndView modelAndView = new ModelAndView("form", "declaration", new Declaration());
        modelAndView.addObject("yearOfBirth", new int[]{1996, 1997, 1998, 1999, 2001, 2002, 2003, 2004, 2005});
        modelAndView.addObject("nationality", new String[]{"Việt Nam", "Anh Quốc", "Hoa Kỳ", "Nhật Bản", "Hàn Quốc"});
        modelAndView.addObject("transportVehicle", new String[]{"Tàu bay", "Tàu thuyền", "Ô tô", "Khác (Ghi rõ)"});
        return modelAndView;
    }

    @PostMapping(value = "/save", produces = "application/x-www-font-urlencoded;charset=UTF-8")
    public ModelAndView showDetail(@ModelAttribute Declaration declaration) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("declaration", declaration);
        return modelAndView;
    }

}
