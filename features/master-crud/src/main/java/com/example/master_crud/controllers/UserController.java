package com.example.master_crud.controllers;

import com.example.master_crud.dtos.request.UserCreateRequest;
import com.example.master_crud.dtos.response.UserResponse;
import com.example.master_crud.services.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return userService.get(id);
    }

    @PostMapping
    public void create(@Valid @RequestBody UserCreateRequest userCreateRequest){
        userService.create(userCreateRequest);
    }
}
