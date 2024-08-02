package com.learn.learn_java.services;

import com.learn.learn_java.dtos.request.CreateUserRequest;
import com.learn.learn_java.dtos.request.UpdateUserRequest;
import com.learn.learn_java.dtos.response.UserResponse;
import com.learn.learn_java.entities.User;
import com.learn.learn_java.exceptions.AppException;
import com.learn.learn_java.exceptions.ErrorCode;
import com.learn.learn_java.mapper.UserMapper;
import com.learn.learn_java.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public UserResponse createUser(CreateUserRequest request) {
        boolean isExistedUser = userRepository.existsByUsername(request.getUsername());
        if (isExistedUser) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        User user = userMapper.toUser(request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponse updateUser(String userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));

        userMapper.updateUser(user, request);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    public UserResponse getUser(String userId) {
        return userMapper.toUserResponse(userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!")));
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
