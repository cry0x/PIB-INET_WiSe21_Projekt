package com.forum.backend.controllers;

import com.forum.backend.entities.User;
import com.forum.backend.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/profile")
@CrossOrigin(origins="*")
public class ProfileController {

    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    private final UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/current")
    public User getCurrentUser() {
        String userLoginname = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User)
            userLoginname = ((User) principal).getLoginname();

        return this.userService.findUserByName(userLoginname);
    }

    @GetMapping("/admin")
    public boolean getIsCurrentUserAdmin() {
        String userLoginname = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User)
            userLoginname = ((User) principal).getLoginname();

        return userLoginname.equals("admin");
    }

    @PutMapping(value = "/current", consumes = "application/json")
    public User updateCurrentUser(@RequestBody User user) {
        String loginname = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User)
            loginname = ((User) principal).getLoginname();

        User existingUser = this.userService.findUserByName(loginname);

        user.setId(existingUser.getId());
        user.setPassword(existingUser.getPassword());

        return this.userService.saveUser(user);
    }

}
