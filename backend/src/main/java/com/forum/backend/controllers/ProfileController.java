package com.forum.backend.controllers;

import com.forum.backend.entities.User;
import com.forum.backend.entities.UserProfilDto;
import com.forum.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/profile")
public class ProfileController {

    private UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/current")
    public UserProfilDto getCurrentUser() {
        String username = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        return getUserProfilDto(this.userService.findUserByName(username));
    }

    @PutMapping(value = "/current", consumes = "application/json")
    public UserProfilDto updateCurrentUser(@RequestBody UserProfilDto userProfilDto) {
        UserProfilDto newUserProfilDto = updateUserFromUserProfileDto(userProfilDto);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        return newUserProfilDto;
    }

    @PutMapping(value = "/current/password")
    public void updateCurrentUserPassword(@RequestBody String userPassword) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    }

    private UserProfilDto updateUserFromUserProfileDto(UserProfilDto userProfilDto) {
        User user = this.userService.readUserById(userProfilDto.getId());

        return getUserProfilDto(this.userService.saveUser(user));
    }

    public UserProfilDto getUserProfilDto(User user) {
        UserProfilDto userProfilDto = new UserProfilDto();


        return userProfilDto;
    }

}
