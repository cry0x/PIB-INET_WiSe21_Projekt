package com.forum.backend.services;

import com.forum.backend.entities.AuthenticatedUser;
import com.forum.backend.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private UserService userService;

    @Autowired
    public ProfileService(UserService userService) {
        this.userService = userService;
    }

    public User getCurrentUser() {
        String userLoginname = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User)
            userLoginname = ((User) principal).getLoginname();

        return this.userService.findUserByName(userLoginname);
    }

    public boolean isUserLoggedIn() {
        String userLoginname = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User)
            userLoginname = ((User) principal).getLoginname();

        AuthenticatedUser authenticatedUser = null;

        try {
            authenticatedUser = new AuthenticatedUser(this.userService.findUserByName(userLoginname));
        } catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
        }

        return authenticatedUser != null ? authenticatedUser.isEnabled() : false;
    }

    public boolean getIsCurrentUserAdmin() {
        String userLoginname = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User)
            userLoginname = ((User) principal).getLoginname();

        return userLoginname.equals("admin");
    }

    public User updateCurrentUser(User user) {
        String loginname = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User)
            loginname = ((User) principal).getLoginname();

        User existingUser = this.userService.findUserByName(loginname);

        user.setId(existingUser.getId());
        user.setPassword(existingUser.getPassword());

        return this.userService.saveUser(user);
    }

}
