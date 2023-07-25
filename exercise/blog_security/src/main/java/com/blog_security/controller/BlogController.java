package com.blog_security.controller;

import com.blog_security.model.Blog;
import com.blog_security.model.Category;
import com.blog_security.service.itf.IBlogService;
import com.blog_security.service.itf.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    private IBlogService blogService;
    private ICategoryService categoryService;

    private BlogController(IBlogService blogService, ICategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @ModelAttribute("blogs")
    public List<Blog> getBlogList() {
        return blogService.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @ModelAttribute("blog")
    public Blog getBlog() {
        return new Blog();
    }

    @ModelAttribute("category")
    public Category getCategory() {
        return new Category();
    }

    @GetMapping("")
    public String showBlogPage(@RequestParam Optional<Integer> page,
                               @RequestParam(defaultValue = "0") int id,
                               Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 3);
        Page<Blog> blogPage;
        if (id == 0) {
            blogPage = blogService.findAll(pageable);
        } else {
            blogPage = blogService.findByCategory(pageable, id);
            Category category = categoryService.findOne(id);
            model.addAttribute("category", category);
        }
        model.addAttribute("blogPage", blogPage);
        return "blog/list";
    }

    @GetMapping("/add")
    public String initCreate() {
        return "blog/add";
    }

    @PostMapping("/add")
    public String create(@RequestParam String action,
                         @ModelAttribute Blog blog,
                         Model model) {
        if (action.equals("Add new")) {
            model.addAttribute("blog", blog);
            return "blog/addCategory";
        } else {
            blogService.add(blog);
            return "redirect:/blog";
        }
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model) {
        Blog blog = blogService.findOne(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        blogService.delete(id);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String initUpdate(@PathVariable int id, Model model) {
        Blog blog = blogService.findOne(id);
        model.addAttribute("blog", blog);
        return "blog/update";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Blog blog) {
        blogService.update(blog);
        return "redirect:/blog";
    }

    @PostMapping("/add-new-category")
    public RedirectView createCategory(@ModelAttribute Category category,
                                       @ModelAttribute Blog blog,
                                       RedirectAttributes redirectAttributes) {
        RedirectView redirectView = new RedirectView("/blog/add");
        categoryService.add(category);
        redirectAttributes.addFlashAttribute("blog", blog);
        return redirectView;
    }
}
