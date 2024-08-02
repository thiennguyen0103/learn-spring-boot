package com.learn.learn_java.dtos.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserRequest {
    @Size(min = 3, message = "USERNAME_INVALID")
    String username;
    String firstName;
    String lastName;

    @Size(min = 8, message = "INVALID_PASSWORD")
    String password;
}
