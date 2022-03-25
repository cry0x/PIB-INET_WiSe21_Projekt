package com.forum.backend.controllers;

import com.forum.backend.entities.AuthenticatedUser;
import com.forum.backend.entities.User;
import com.forum.backend.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/profile")
public class ProfileController {

    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    private UserService userService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ProfileController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/current")
    public User getCurrentUser() throws Exception {
        String userLoginname = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User)
            userLoginname = ((User) principal).getLoginname();

        return this.userService.findUserByName(userLoginname);
    }

    @PutMapping(value = "/current", consumes = "application/json")
    public User updateCurrentUser(@RequestBody User user) {
        String loginname = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User)
            loginname = ((User) principal).getLoginname();

        user.setId(this.userService.findUserByName(loginname).getId());

        user = this.userService.saveUser(user);

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(user.getLoginname(), user.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authRequest);

        principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User)
           logger.info(((User) principal).getLoginname());

        return user;
    }

}
