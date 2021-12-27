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

        if (principal instanceof User)
            username = ((User)principal).getUsername();

        return getUserProfilDto(this.userService.findUserByName(username));
    }

    @PutMapping(value = "/current", consumes = "application/json")
    public UserProfilDto updateCurrentUser(@RequestBody UserProfilDto userProfilDto) {
        UserProfilDto newUserProfilDto = updateUserFromUserProfileDto(userProfilDto);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User)
            ((User)principal).setUsername(newUserProfilDto.getLoginName());

        return newUserProfilDto;
    }

    @PutMapping(value = "/current/password")
    public void updateCurrentUserPassword(@RequestBody String userPassword) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User) {
            ((User)principal).setPassword(userPassword);
            this.userService.createUser((User)principal);
        }
    }

    private UserProfilDto updateUserFromUserProfileDto(UserProfilDto userProfilDto) {
        User user = this.userService.readUserById(userProfilDto.getId());

        user.setLogin_name(userProfilDto.getLoginName());
        user.setFirstname(userProfilDto.getFirstName());
        user.setLastname(userProfilDto.getLastName());
        user.setEmail(userProfilDto.getEmail());
        user.setBirthdate(userProfilDto.getBirthdate());
        user.setPictureUrl(userProfilDto.getPictureUrl());

        return getUserProfilDto(this.userService.createUser(user));
    }

    public UserProfilDto getUserProfilDto(User user) {
        UserProfilDto userProfilDto = new UserProfilDto();

        userProfilDto.setId(user.getId());
        userProfilDto.setLoginName(user.getLogin_name());
        userProfilDto.setFirstName(user.getFirstname());
        userProfilDto.setLastName(user.getLastname());
        userProfilDto.setEmail(user.getEmail());
        userProfilDto.setBirthdate(user.getBirthdate());
        userProfilDto.setPictureUrl(user.getPictureUrl());
        userProfilDto.setRegistrationdate(user.getRegistrationdate());

        return userProfilDto;
    }

}
