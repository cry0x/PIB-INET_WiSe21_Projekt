package com.forum.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class ViewController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index.html");
        registry.addViewController("/main").setViewName("/html/main.html");
        registry.addViewController("/registration").setViewName("/html/registration.html");
        registry.addViewController("/login").setViewName("/html/login.html");
    }

}
