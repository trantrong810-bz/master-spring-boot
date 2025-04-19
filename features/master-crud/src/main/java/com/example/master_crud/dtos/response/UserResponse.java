package com.example.master_crud.dtos.response;

import com.example.master_crud.dtos.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResponse {
    private String name;
    private String email;
    private Gender gender;
}
