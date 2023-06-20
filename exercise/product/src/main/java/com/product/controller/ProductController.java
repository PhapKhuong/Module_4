package com.product.controller;

import com.product.model.Product;
import com.product.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private IProductService service;

    private ProductController(IProductService service) {
        this.service = service;
    }

    @ModelAttribute("products")
    public List<Product> getProductList() {
        return service.findAll();
    }

    @GetMapping("/list")
    public String showList(Model model) {
        Product product = new Product();
        String name = "";
        model.addAttribute("product", product);
        model.addAttribute("name", name);
        return "list";
    }

    @GetMapping("/add")
    public String initCreate(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute Product product, Model model) {
        if (service.create(product)) {
            return "redirect:/product/list";
        } else {
            String msg = "Product's Id is exist!";
            model.addAttribute("error", msg);
            return "add";
        }
    }

    @PostMapping("/delete")
    public String deleteProduct(@ModelAttribute Product product) {
        service.delete(product.getId());
        return "redirect:/product/list";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product) {
        service.update(product.getId(), product);
        return "redirect:/product/list";
    }


}
