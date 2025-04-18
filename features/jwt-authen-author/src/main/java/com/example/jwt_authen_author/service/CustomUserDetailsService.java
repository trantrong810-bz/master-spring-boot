package com.example.jwt_authen_author.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) {
        // Mocked user (you'd normally fetch from DB)
        if (username.equals("admin")) {
            return new org.springframework.security.core.userdetails.User(
                "admin",
                new BCryptPasswordEncoder().encode("admin123"),
                List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))
            );
        }
        return new org.springframework.security.core.userdetails.User(
            "user",
            new BCryptPasswordEncoder().encode("user123"),
            List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
