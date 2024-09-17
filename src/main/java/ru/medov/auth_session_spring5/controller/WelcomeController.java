package ru.medov.auth_session_spring5.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcomeToAll(){
        return "Welcome, anonim!";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admins")
    public String welcomeToAdmins(){
        return "Welcome, admin!";
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/users")
    public String welcomeToUsers(){
        return "Welcome, user!";
    }
}
