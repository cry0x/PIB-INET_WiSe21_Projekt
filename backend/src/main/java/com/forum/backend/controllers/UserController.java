package com.forum.backend.controllers;

import com.forum.backend.entities.User;
import com.forum.backend.entities.UserDto;
import com.forum.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;
    public final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@ModelAttribute UserDto userDto) {
        userDto.setPwd(bCryptPasswordEncoder.encode(userDto.getPwd()));

        return new ResponseEntity<>(this.userService.createUser(userDto.getUser()), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> readUserById(@PathVariable Long id) {
        return new ResponseEntity<>(this.userService.readUserById(id), HttpStatus.FOUND);
    }

    @GetMapping(produces = "application/json;charset=UTF-8")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUserById(@PathVariable Long id) {
        this.userService.deleteUserById(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
