package com.forum.backend;

import com.forum.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public AuthService authService;
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public WebSecurityConfig(AuthService authService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.authService = authService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                    .authorizeRequests()
                    .antMatchers("/html/about.html").hasRole("USER")
                    .antMatchers("/", "/**", "/api/v1/users").permitAll()
                    .anyRequest().permitAll()
                .and()
                    .formLogin()
                    .permitAll()
                .and()
                    .csrf()
                    .disable();
    }

}
