package com.example.jwt_authen_author.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/user")
    public String userAccess() {
        return "Hello, authenticated user!";
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/admin")
    public String adminAccess() {
        return "Hello, admin!";
    }
}
