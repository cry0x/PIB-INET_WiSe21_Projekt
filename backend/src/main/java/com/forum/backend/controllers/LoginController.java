package com.forum.backend.controllers;

import com.forum.backend.entities.UserProfilDto;
import com.forum.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("logintest")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public UserProfilDto readUserById() {
        String username = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails)
            username = ((UserDetails)principal).getUsername();

        return this.userService.findUserByName(username).getUserProfilDto();
    }

}
