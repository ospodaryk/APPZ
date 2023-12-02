package com.project.appz.controller;

import com.project.appz.entities.User;
import com.project.appz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        logger.info("______@GetMapping(\"/create\")");
        model.addAttribute("user", new User());
        return "create-user";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            logger.error("______@PostMapping(\"/create\")" + result.getAllErrors().toString());
            return "create-user";
        }
        logger.info("@PostMapping(\"/create\")");
        user.setPassword(user.getPassword());
        User newUser = userService.create(user);
        return "redirect:/home";
    }

    @PreAuthorize("hasAuthority('ADMIN') or #id==authentication.principal.id")
    @GetMapping("/{id}/read")
    public String read(@PathVariable long id, Model model) {
        logger.info("______@GetMapping(\"/{id}/read\")");
        User user = userService.readById(id);
        model.addAttribute("user", user);
        return "user-info";
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users-list";
    }
}
