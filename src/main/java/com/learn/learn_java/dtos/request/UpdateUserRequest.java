package com.learn.learn_java.dtos.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateUserRequest {
    String password;
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
}
