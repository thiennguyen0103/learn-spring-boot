package com.learn.learn_java.mapper;

import com.learn.learn_java.dtos.request.CreateUserRequest;
import com.learn.learn_java.dtos.request.UpdateUserRequest;
import com.learn.learn_java.dtos.response.UserResponse;
import com.learn.learn_java.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(CreateUserRequest request);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UpdateUserRequest request);
}
