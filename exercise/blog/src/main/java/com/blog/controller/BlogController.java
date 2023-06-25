package com.blog.controller;

import com.blog.model.Blog;
import com.blog.service.IBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    private IBlogService service;

    private BlogController(IBlogService service) {
        this.service = service;
    }

    @ModelAttribute("blogs")
    public List<Blog> getBlogList() {
        return service.findAll();
    }

    @GetMapping("")
    public String showList() {
        return "list";
    }

    @GetMapping("/add")
    public String initCreate(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        return "add";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute Blog blog) {
        service.add(blog);
        return "redirect:/blog";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model) {
        Blog blog = service.findOne(id);
        model.addAttribute("blog", blog);
        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String initUpdate(@PathVariable int id, Model model) {
        Blog blog = service.findOne(id);
        model.addAttribute("blog", blog);
        return "update";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Blog blog) {
        service.update(blog);
        return "redirect:/blog";
    }

}
