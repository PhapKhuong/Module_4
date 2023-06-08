package com.the_first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TheFirst {

    @RequestMapping(value = "/hello-world")
    public String showList() {
        return "/hello";
    }
}