package com.account.controller;

import com.account.model.Role;
import com.account.model.User;
import com.account.exception.ExistException;
import com.account.exception.ValidateException;
import com.account.service.itf.RoleService;
import com.account.service.itf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public String showListUser(Model model) {
        List<User> users = userService.display();
        model.addAttribute("users", users);
        return "home";
    }

    //============================================================
    @PostMapping("/init-create-user")
    public ModelAndView doInitCreateUser(ModelAndView mv) {
        List<User> users = userService.display();
        int initUserId = 0;
        int maxCode = 0;
        if (users.size() == 0) {
            initUserId = 1;
            maxCode = 1;
        } else {
            for (User user : users) {
                int id = user.getUserId();
                int code = Integer.parseInt(user.getCode().substring(2));
                if (id + 1 > initUserId) {
                    initUserId = id + 1;
                }
                if (code + 1 > maxCode) {
                    maxCode = code + 1;
                }
            }
        }

        String initCode;
        if (maxCode < 10) {
            initCode = "U-000" + maxCode;
        } else if (maxCode < 100) {
            initCode = "U-00" + maxCode;
        } else if (maxCode < 1000) {
            initCode = "U-0" + maxCode;
        } else {
            initCode = "U-" + maxCode;
        }

        mv.setViewName("create");
        mv.addObject("userId", initUserId);
        mv.addObject("code", initCode);
        return mv;
    }

    @PostMapping("/create-user")
    public String doCreateUser(
            @RequestParam int userId, @RequestParam String userName,
            @RequestParam String code, @RequestParam String birthday,
            @RequestParam String initTime, @RequestParam int[] role,
            Model model) {
        try {
            List<User> users = userService.display();

            for (User user : users) {
                if (user.getUserId() == userId || user.getCode().equals(code)) {
                    throw new ExistException();
                }
            }

            if (!code.matches("^U-[\\d]{4}$")) {
                throw new ValidateException();
            }

            List<Role> roleList = new ArrayList<>();
            for (int r : role) {
                Role newRole = roleService.search(r);
                roleList.add(newRole);
            }

            LocalDate d = LocalDate.parse(birthday);
            LocalDateTime t = LocalDateTime.parse(initTime);

            User user = new User(userId, userName, code, d, t, roleList);
            userService.create(user);

            return "redirect:/account";
        } catch (NullPointerException e) {
            String errorMsg = "Ban chua chon role";
            model.addAttribute("error", errorMsg);
            return "create";
        } catch (ExistException e) {
            String errorMsg = "Ma nguoi dung da ton tai";
            model.addAttribute("error", errorMsg);
            return "create";
        } catch (ValidateException e) {
            String errorMsg = "Ma code nguoi dung khong dung dinh dang";
            model.addAttribute("error", errorMsg);
            return "create";
        }
    }

    @PostMapping("/edit-user")
    private String doEditUser(
            @RequestParam int userId, @RequestParam String userName,
            @RequestParam String code, @RequestParam LocalDate birthday,
            @RequestParam LocalDateTime initTime,
            @RequestParam int[] role, Model model) {
        try {

            List<Role> roleList = new ArrayList<>();
            for (int r : role) {
                Role newRole = roleService.search(r);
                roleList.add(newRole);
            }

            User user = new User(userId, userName, code, birthday, initTime, roleList);
            userService.update(user);

            return "redirect:home";
        } catch (NullPointerException e) {
            String errorMsg = "Ban chua chon role";
            model.addAttribute("error", errorMsg);
            return "home";
        }
    }

    @PostMapping("del-user")
    private String doDelUser(@RequestParam int userId) {
        userService.delete(userId);
        return "redirect:/home";
    }

    @PostMapping("/search-user")
    private String doSearchUser(@RequestParam String searchUserByName, Model model) {
        String userName = "%" + searchUserByName + "%";
        List<User> users = userService.search(userName);
        model.addAttribute("users", users);

        return "forward:/home";
    }
}