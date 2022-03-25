package com.forum.backend.controllers;

import com.forum.backend.entities.AuthenticatedUser;
import com.forum.backend.entities.User;
import com.forum.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/profile")
public class ProfileController {

    private UserService userService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ProfileController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/current")
    public User getCurrentUser() {
        String loginname = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User)
            loginname = ((User) principal).getLoginname();

        return this.userService.findUserByName(loginname);
    }

    @PutMapping(value = "/current", consumes = "application/json")
    public User updateCurrentUser(@RequestBody User user) {
        String loginname = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User)
            loginname = ((User) principal).getLoginname();

        user.setId(this.userService.findUserByName(loginname).getId());

        user = this.userService.saveUser(user);

        return user;
    }

}
