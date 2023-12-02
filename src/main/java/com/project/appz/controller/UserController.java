package com.project.appz.controller;

import com.project.appz.entities.User;
import com.project.appz.security.UserSecurityService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserSecurityService service;

    public UserController(UserSecurityService service) {
        this.service = service;
    }

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<User> getAll() {
        return this.service.getAll();
    }
}
