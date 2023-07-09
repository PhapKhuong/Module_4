package com.furama.controller;

import com.furama.model.Customer;
import com.furama.model.CustomerType;
import com.furama.service.itf.ICustomerService;
import com.furama.service.itf.ICustomerTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/f")
public class FController {
    private ICustomerTypeService customerTypeService;
    private ICustomerService customerService;

    private FController(ICustomerTypeService customerTypeService,
                        ICustomerService customerService) {
        this.customerTypeService = customerTypeService;
        this.customerService = customerService;
    }

    @ModelAttribute("customerTypes")
    public List<CustomerType> getCustomerTypeList() {
        return customerTypeService.findAll();
    }

    @GetMapping("")
    public String goHome() {
        return "furama/home";
    }

    @GetMapping("/customer")
    public String showCustomer(@RequestParam Optional<Integer> page,
                               Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        Page<Customer> customerPage = customerService.findAll(pageable);
        model.addAttribute("customerPage", customerPage);
        return "furama/home";
    }

    @GetMapping("/customer/add")
    public String showFormCreateCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "furama/addCustomer";
    }

    @PostMapping("/customer/add")
    public String createCustomer(@ModelAttribute Customer customer) {
        customerService.addOne(customer);
        return "redirect:/f/customer";
    }
}
