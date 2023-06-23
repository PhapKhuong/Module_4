package com.picture.controller;

import com.picture.model.Feedback;
import com.picture.service.IPictureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/picture-of-day")
public class PictureController {
    private IPictureService service;

    private PictureController(IPictureService service) {
        this.service = service;
    }

    @ModelAttribute("feedbacks")
    public List<Feedback> getFeedbackList() {
        return service.find();
    }

    @GetMapping("")
    public String display(Model model) {
        Feedback feedback = new Feedback();
        model.addAttribute("feedback", feedback);
        return "list";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Feedback feedback, Model model) {
        if (!service.add(feedback)) {
            String errorMsg = "Adding new failed!";
            model.addAttribute("error", errorMsg);
            return "list";
        }
        return "redirect:/picture-of-day";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Feedback feedback) {
        int id = feedback.getFbId();
        service.update(id);
        return "redirect:/picture-of-day";
    }
}
