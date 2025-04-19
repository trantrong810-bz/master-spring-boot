package com.example.master_crud.services;

import com.example.master_crud.dtos.request.UserCreateRequest;
import com.example.master_crud.dtos.response.UserResponse;
import jakarta.validation.Valid;

public interface IUserService {
    UserResponse get(Long id);

    void create(@Valid UserCreateRequest userCreateRequest);
}
