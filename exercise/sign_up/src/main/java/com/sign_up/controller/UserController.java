package com.sign_up.controller;

import com.sign_up.dto.UserDto;
import com.sign_up.model.User;
import com.sign_up.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    private IUserService service;

    private UserController(IUserService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String showList(@RequestParam Optional<Integer> page,
                           Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 2);
        Page<User> userPage = service.findAll(pageable);
        model.addAttribute("userPage", userPage);
        return "list";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam String username, Model model) {
        User user = service.findOne(username);
        model.addAttribute("user", user);
        return "detail";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute(userDto);
        return "form";
    }

    @PostMapping("/add")
    public String creatUser(@Valid @ModelAttribute UserDto userDto,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "form";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setAge(Integer.parseInt(userDto.getAge()));
        service.addOne(user);
        redirectAttributes.addFlashAttribute("msg", "Add new success");
        return "redirect:/user/list";
    }
}
