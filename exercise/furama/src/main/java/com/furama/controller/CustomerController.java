package com.furama.controller;

import com.furama.model.Customer;
import com.furama.model.CustomerType;
import com.furama.service.itf.ICustomerService;
import com.furama.service.itf.IFinalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private IFinalService finalService;
    private ICustomerService customerService;

    private CustomerController(IFinalService finalService,
                               ICustomerService customerService) {
        this.finalService = finalService;
        this.customerService = customerService;
    }

    @ModelAttribute("customerTypes")
    public List<CustomerType> getCustomerTypeList() {
        return finalService.findCustomerTypeList();
    }

    @GetMapping("")
    public String showCustomer(@RequestParam Optional<Integer> page,
                               @RequestParam Optional<String> name,
                               Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        String strName = "%" + name.orElse("") + "%";
        Page<Customer> customerPage = customerService.findAll(pageable, strName);
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("name", name.orElse(""));
        return "customer/list-customer";
    }

    @GetMapping("/add")
    public String showFormCreateCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer/add-customer";
    }

    @PostMapping("/add")
    public String createCustomer(@ModelAttribute Customer customer) {
        customerService.addOne(customer);
        return "redirect:/customer";
    }
}
