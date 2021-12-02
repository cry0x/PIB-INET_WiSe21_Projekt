package com.forum.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class ViewController implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.html");
        registry.addViewController("/about").setViewName("html/about.html");
        registry.addViewController("/contact").setViewName("html/contact.html");
        registry.addViewController("/registration").setViewName("html/registration.html");
        registry.addViewController("/login").setViewName("html/login.html");
    }
}
