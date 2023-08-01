package com.furama.controller;

import com.furama.model.*;
import com.furama.service.itf.IEmployeeService;
import com.furama.service.itf.IFinalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private IFinalService finalService;
    private IEmployeeService employeeService;

    private EmployeeController(IFinalService finalService,
                               IEmployeeService employeeService) {
        this.finalService = finalService;
        this.employeeService = employeeService;
    }

    @ModelAttribute("positionList")
    public List<Position> getPositionList() {
        return finalService.findPositionList();
    }

    @ModelAttribute("educationDegreeList")
    public List<EducationDegree> getEducationDegreeList() {
        return finalService.findEducationDegreeList();
    }

    @ModelAttribute("divisionList")
    public List<Division> getDivisionList() {
        return finalService.findDivisionList();
    }

    @ModelAttribute("roleList")
    public List<Role> getRoleList() {
        return finalService.findRoleList();
    }

    @GetMapping("")
    public String showEmployee(@RequestParam Optional<Integer> page,
                               @RequestParam Optional<String> name,
                               Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        String strName = "%" + name.orElse("") + "%";
        Page<Employee> employeePage = employeeService.findAll(pageable, strName);
        model.addAttribute("employeePage", employeePage);
        model.addAttribute("name", name.orElse(""));
        return "employee/list-employee";
    }

}
