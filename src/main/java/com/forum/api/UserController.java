package com.forum.api;

import com.forum.entities.User;
import com.forum.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(@ModelAttribute User user) {
        return this.userService.createUser(user);
    }

    @GetMapping("/all")
    public Iterable<User> all() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> userById(@PathVariable Long id) {
        return this.userService.readUser(id);
    }

    @GetMapping("/count")
    public Long getUserCount() {
        return this.userService.count();
    }

}
