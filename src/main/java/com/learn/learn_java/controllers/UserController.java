package com.learn.learn_java.controllers;

import com.learn.learn_java.dtos.request.CreateUserRequest;
import com.learn.learn_java.dtos.request.UpdateUserRequest;
import com.learn.learn_java.dtos.response.ApiResponse;
import com.learn.learn_java.dtos.response.UserResponse;
import com.learn.learn_java.services.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid CreateUserRequest request) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userService.createUser(request));

        return apiResponse;
    }

    @PutMapping("/{userId}")
    ApiResponse<UserResponse> updateUser(@PathVariable String userId, @RequestBody @Valid UpdateUserRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.updateUser(userId, request))
                .build();
    }

    @GetMapping
    ApiResponse<List<UserResponse>> getAllUsers() {
        ApiResponse<List<UserResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.getUsers());

        return apiResponse;
    }

    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUser(@PathVariable String userId) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.getUser(userId));

        return apiResponse;
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }
}
