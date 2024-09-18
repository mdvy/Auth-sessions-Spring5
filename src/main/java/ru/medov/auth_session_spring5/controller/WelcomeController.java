package ru.medov.auth_session_spring5.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.medov.auth_session_spring5.security.PersonDetails;

import java.net.ContentHandler;

@RestController
@RequestMapping("/test")
public class WelcomeController {


    @GetMapping("/welcome")
    public String welcomeToAll(){
        return "Welcome, anon!";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admins")
    public String welcomeToAdmins(){
        PersonDetails personDetails = ((PersonDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "Welcome, admin " + personDetails.getUsername();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/users")
    public String welcomeToUsers(){
        PersonDetails personDetails = ((PersonDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "Welcome, user " + personDetails.getUsername();
    }
}
