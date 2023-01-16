package com.example.springsecurity.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {

    @GetMapping("/")
    public String index(Model model){
        return "/index";
    }

    @GetMapping("/user")
    public String user(Model model, Principal principal){
        // get authenticated user name from Principal
        System.out.println(principal.getName());
        return "/user";
    }

    @GetMapping("/admin")
    public String admin(Model model){
        // get authenticated user name from SecurityContext
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context.getAuthentication().getName());
        return "/admin";
    }
}
