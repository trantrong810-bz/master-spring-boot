package com.example.master_crud.services;

import com.example.master_crud.common.exceptions.MasterCrudException;
import com.example.master_crud.dtos.Gender;
import com.example.master_crud.dtos.request.UserCreateRequest;
import com.example.master_crud.dtos.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class IUserServiceImpl implements IUserService {

    private static final Map<Long, UserResponse> USERS = Map.of(
            1L, new UserResponse("Alice Smith", "alice@example.com", Gender.FEMALE),
            2L, new UserResponse("Bob Johnson", "bob@example.com", Gender.MALE),
            3L, new UserResponse("Carol Williams", "carol@example.com", Gender.FEMALE)
    );

    @Override
    public UserResponse get(Long id) {
        return Optional.ofNullable(USERS.get(id))
                .orElseThrow(() -> new MasterCrudException("User with ID " + id + " not found"));
    }

    @Override
    public void create(UserCreateRequest userCreateRequest) {
    }
}
