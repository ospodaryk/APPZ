package com.project.appz.controller;

import com.project.appz.dto.UserResponse;
import com.project.appz.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    public static UserResponse userResponse = new UserResponse();
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/", "home", "test"})
    public String home(Model model) {
        model.addAttribute("users", userService.getAll());
        return "home";
    }

    @GetMapping({"/additional",})
    public String add(Model model) {
        return "add";
    }

    @GetMapping("/form-login")
    public String login() {
        userResponse.clean();
        return "form-login";
    }
}