package com.forum.backend.controllers;

import com.forum.backend.entities.AuthenticatedUser;
import com.forum.backend.entities.User;
import com.forum.backend.services.ProfileService;
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

    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/current")
    public User getCurrentUser() {
        logger.info("GET /api/profile/current");

        return this.profileService.getCurrentUser();
    }

    @GetMapping(path = "/loggedin")
    public boolean isUserLoggedIn() {
        logger.info("GET /api/profile/loggedin");

        return this.profileService.isUserLoggedIn();
    }

    @GetMapping("/admin")
    public boolean getIsCurrentUserAdmin() {
        logger.info("GET /api/profile/admin");

        return this.profileService.getIsCurrentUserAdmin();
    }

    @PutMapping(value = "/current", consumes = "application/json")
    public User updateCurrentUser(@RequestBody User user) {
        logger.info("PUT /api/profile/current");

        return this.profileService.updateCurrentUser(user);
    }

}
