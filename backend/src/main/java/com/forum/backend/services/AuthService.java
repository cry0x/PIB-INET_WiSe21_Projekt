package com.forum.backend.services;

import com.forum.backend.entities.AuthenticatedUser;
import com.forum.backend.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public AuthService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public AuthenticatedUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userService.findUserByName(username);

        return new AuthenticatedUser(user);
    }
}
