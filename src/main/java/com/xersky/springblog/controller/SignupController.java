package com.xersky.springblog.controller;

import com.xersky.springblog.entity.Role;
import com.xersky.springblog.entity.User;
import com.xersky.springblog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    private final UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute User user) {
        user.setRole(Role.USER);
        user.getAuthor().setUser(user);
        userService.createUser(user);
        return "redirect:/";
    }
}
