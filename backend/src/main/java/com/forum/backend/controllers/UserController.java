package com.forum.backend.controllers;

import com.forum.backend.entities.User;
import com.forum.backend.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
@CrossOrigin(origins="*")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(path = "/{userId}")
    public User getUserById(@PathVariable Long userId) throws Exception {
        logger.info(String.format("GET /api/user/%s", userId));

        return this.userService.readUserById(userId);
    }

    @GetMapping
    public List<User> getAllUsers() {
        logger.info("GET /api/user");

        return this.userService.readAllUsers();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public User postUser(@RequestBody User user) {
        logger.info(String.format("POST /api/user %s", user.toString()));

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return this.userService.saveUser(user);
    }

    @DeleteMapping(path = "/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        logger.info(String.format("DELETE /api/user/%s", userId));

        this.userService.deleteUser(userId);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody User user) {
        logger.info(String.format("DELETE /api/user %s", user.toString()));

        if (user.getId() == null)
            throw new RuntimeException("The user to be deleted doesnt have an id!");

        this.userService.deleteUser(user.getId());
    }

}
