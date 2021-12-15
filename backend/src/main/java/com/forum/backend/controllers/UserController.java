package com.forum.backend.controllers;

import com.forum.backend.entities.User;
import com.forum.backend.entities.UserDto;
import com.forum.backend.entities.UserProfilDto;
import com.forum.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public User updateUser(@PathVariable Long id, @RequestBody UserProfilDto userProfilDto) {
        User user = this.userService.readUserById(id);

        user.setLogin_name(userProfilDto.getLoginName());
        user.setFirstname(userProfilDto.getFirstName());
        user.setLastname(userProfilDto.getLastName());
        user.setEmail(userProfilDto.getEmail());
        user.setBirthdate(userProfilDto.getBirthdate());

        return this.userService.createUser(user);
    }

    @GetMapping(value = "/{id}")
    public User readUserById(@PathVariable Long id) {
        return this.userService.readUserById(id);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@ModelAttribute UserDto userDto) {
        userDto.setPwd(bCryptPasswordEncoder.encode(userDto.getPwd()));

        return new ResponseEntity<>(this.userService.createUser(userDto.getUser()), HttpStatus.CREATED);
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
