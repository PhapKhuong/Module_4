package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IServiceStudent serviceStudent;
    @ModelAttribute("languages")
    public String[] getLanguages(){
        return new String[]{"JS","PHP","JAVA","SQL"};
    }
    @GetMapping("")
    public String showList(ModelMap model){
        List<Student> studentList = serviceStudent.findAll();
        model.addAttribute("studentList",studentList);
        return "/list";
    }
    @GetMapping(value = "/add")
    public String showFormAdd(Model model){
         model.addAttribute("student", new Student());
//         model.addAttribute("languages", new String[]{"JS","PHP","JAVA","SQL"});
         return "add";
    }
    @GetMapping("/detail")
    public String showEdit(@RequestParam int id, Model model){
        // database
        System.out.println(id);

        return "detail";
    }
//    @GetMapping("/delete/{id}")
    @GetMapping("/delete/*/{id:[0-9]}/{name}")
    public String delete(@PathVariable int id,@PathVariable String name, Model model){
        // database
        System.out.println(id);
        System.out.println(name);

        return "detail";
    }
    @PostMapping("/add")
    public ModelAndView save(@ModelAttribute Student student){

        serviceStudent.add(student);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("mess","Them moi thanh cong");
        List<Student> studentList = serviceStudent.findAll();
        modelAndView.addObject("studentList",studentList);
        return modelAndView;
    }
}
