package com.forum.backend.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AuthenticatedUser extends User implements UserDetails {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticatedUser.class);

    public AuthenticatedUser(User user) {
        this.setFirstname(user.getFirstname());
        this.setLastname(user.getLastname());
        this.setEmail(user.getEmail());
        this.setLoginname(user.getLoginname());
        this.setBirthdate(user.getBirthdate());
        this.setRegistrationdate(user.getRegistrationdate());
        this.setPassword(user.getPassword());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        logger.info("getAuthorities");

        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }

    @Override
    public String getUsername() {
        logger.info("getUsername");

        return getLoginname();
    }

    @Override
    public boolean isAccountNonExpired() {
        logger.info("isAccountNonExpired");

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        logger.info("isAccountNonLocked");

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        logger.info("isCredentialsNonExpired");

        return true;
    }

    @Override
    public boolean isEnabled() {
        logger.info("isEnabled");

        return true;
    }
}
