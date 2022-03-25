package com.forum.backend.controllers;

import com.forum.backend.entities.User;
import com.forum.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/profile")
public class ProfileController {

    private UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/current")
    public User getCurrentUser() {
        String username = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return this.userService.findUserByName(username);
    }

    @PutMapping(value = "/current", consumes = "application/json")
    public User updateCurrentUser(@RequestBody User user) {

        return user;
    }

    @PutMapping(value = "/current/password")
    public void updateCurrentUserPassword(@RequestBody String userPassword) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    }

}
