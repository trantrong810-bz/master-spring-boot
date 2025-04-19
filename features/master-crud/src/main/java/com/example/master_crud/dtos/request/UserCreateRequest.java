package com.example.master_crud.dtos.request;

import com.example.master_crud.dtos.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCreateRequest(
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
        String name,

        @Email(message = "Email should be valid")
        String email,

        Gender gender
) {}
