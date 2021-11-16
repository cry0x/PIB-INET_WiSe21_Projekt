package com.forum.api;

import com.forum.entities.User;
import com.forum.service.UserService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> createUser(@ModelAttribute User user) {
        Optional<User> newUser = Optional.of(this.userService.createOrUpdateUser(user));

        if (!newUser.isPresent())
            return ResponseEntity.badRequest().body("The user could not be created.");

        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readUserById(@PathVariable Long id) {
        Optional<User> user = this.userService.readUserById(id);

        if (!user.isPresent())
            return ResponseEntity.badRequest().body(String.format("There is no user with the ID: %d", id));

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        this.userService.deleteUserById(id);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

}
