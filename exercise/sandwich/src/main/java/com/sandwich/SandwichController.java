package com.sandwich;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {
    @GetMapping("/choose-condiment")
    public String goHome() {
        return "home";
    }

    @PostMapping("/show")
    public ModelAndView showCondiment(@RequestParam("condiment") String[] condiment, ModelAndView mv) {
        mv.setViewName("display");
        mv.addObject("results", condiment);
        return mv;
    }
}
