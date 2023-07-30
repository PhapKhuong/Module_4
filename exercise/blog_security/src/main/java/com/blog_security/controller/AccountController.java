package com.blog_security.controller;

import com.blog_security.exception.SignUpException;
import com.blog_security.model.account.AppRole;
import com.blog_security.model.account.AppUser;
import com.blog_security.model.account.AppUserDto;
import com.blog_security.model.account.UserRole;
import com.blog_security.model.account.key.KeyUserRole;
import com.blog_security.service.account.UserDetailsServiceImpl;
import com.blog_security.util.EncryptedPassword;
import com.blog_security.util.WebUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class AccountController {
    private UserDetailsServiceImpl service;

    public AccountController(UserDetailsServiceImpl service) {
        this.service = service;
    }

    @ModelAttribute("roles")
    public List<AppRole> getRoleList() {
        return service.findRoleList();
    }

    @ModelAttribute("userDto")
    public AppUserDto getUserDto() {
        return new AppUserDto();
    }

    @GetMapping("/signup")
    public String showSignUpForm() {
        return "account/signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute AppUserDto userDto,
                         @Param("role") String[] role,
                         Model model) throws SignUpException {
        AppUser user = service.findUserById(userDto.getUsername());
        if (user != null || role == null) {
            throw new SignUpException();
        }
        String password = EncryptedPassword.encryptedPassword(userDto.getPassword());
        AppUser newUser = new AppUser(userDto.getUsername(), password);
        service.createUser(newUser);
        for (String r : role) {
            KeyUserRole key = new KeyUserRole(newUser.getUsername(), Integer.parseInt(r));
            AppRole appRole = service.findRoleById(Integer.parseInt(r));
            UserRole userRole = new UserRole(key, newUser, appRole);
            service.create(userRole);
        }
        model.addAttribute("msg", "Welcome " + newUser.getUsername() + "!");
        return "account/hello-user";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "account/login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        String msg = "Login fail!";
        model.addAttribute("msg", msg);
        return "account/login-error";
    }

    @GetMapping("/403")
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            User loginSuccessUser = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils.toString(loginSuccessUser);
            model.addAttribute("userInfo", userInfo);
            String message = "Hi " + principal.getName()
                    + "! You do not have permission to access this page";
            model.addAttribute("message", message);
        }
        return "account/403";
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public String usernameNotFoundException(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", "Username Not Found Exception");
        return "redirect:/account/loginPage";
    }

    @ExceptionHandler(SignUpException.class)
    public String signupException(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", "Sign up error!");
        return "redirect:/signup";
    }
}
