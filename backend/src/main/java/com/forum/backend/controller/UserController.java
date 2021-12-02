package com.forum.backend.controller;

import com.forum.backend.entities.User;
import com.forum.backend.entities.UserDto;
import com.forum.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<User> createUser(@ModelAttribute UserDto userDto) {
        System.out.println(userDto.getBirth());
        return new ResponseEntity<>(this.userService.createUser(userDto.getUser()), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> readUserById(@PathVariable Long id) {
        return new ResponseEntity<>(this.userService.readUserById(id), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUserById(@PathVariable Long id) {
        this.userService.deleteUserById(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
