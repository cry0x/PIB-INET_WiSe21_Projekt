package com.forum.backend.services;

import com.forum.backend.entities.AuthenticatedUser;
import com.forum.backend.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthenticatedUser loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("admin"))
            return new AuthenticatedUser(getAdminUser());

        return new AuthenticatedUser(this.userService.findUserByName(username));
    }

    private User getAdminUser() {
        User adminUser = new User();
        adminUser.setFirstname("admin");
        adminUser.setLastname("admin");
        adminUser.setLoginname("admin");
        adminUser.setEmail("admin@admin.de");
        adminUser.setBirthdate(LocalDate.of(2000, 01, 01));
        adminUser.setPassword(passwordEncoder.encode("admin"));

        return adminUser;
    }

}
