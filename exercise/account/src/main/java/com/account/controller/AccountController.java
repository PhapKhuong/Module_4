package com.account.controller;

import com.account.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class AccountController {


    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcomePage";
    }

    @GetMapping("/admin")
    public String adminPage(Model model, Principal principal) {
        User loginUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginUser);
        model.addAttribute("userInfo", userInfo);
        return "adminPage";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "loginPage";
    }

    @GetMapping("/logoutSuccessful")
    public String logoutSuccessfulPage() {
        return "logoutSuccessfulPage";
    }

    @GetMapping("/loginSuccessful")
    public String loginSuccessfulPage(Model model, Principal principal) {
        User loginSuccessUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginSuccessUser);
        model.addAttribute("userInfo", userInfo);
        return "loginSuccessfulPage";
    }

    @GetMapping("/403")
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            User loginSuccessUser = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils.toString(loginSuccessUser);
            model.addAttribute("userInfo", userInfo);
            String message = "Hi " + principal.getName()
                    + "<br> You do not have permission to access this page";
            model.addAttribute("message", message);
        }
        return "403Page";
    }
    @ExceptionHandler(UsernameNotFoundException.class)
    public String usernameNotFoundException(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", "Username Not Found Exception");
        return "redirect:/loginPage";
    }
}
