package com.forum.controller;

import com.forum.entities.User;
import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@ModelAttribute User user) {
        return ResponseEntity.ok(this.userService.createUser(user));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> readUserById(@PathVariable Long id) {
        return ResponseEntity.ok(this.userService.readUserById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        this.userService.deleteUserById(id);
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

}
