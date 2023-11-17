package com.youcode.YouQuiz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserDto {
    @NotBlank(message = "first name should not be empty")
    protected String firstName;
    @NotBlank(message = "last name should not be empty")
    protected String lastName;
    @NotNull(message = "birthdate should not be empty")
    protected LocalDate birthDate;
    @NotBlank(message = "address should not be empty")
    protected String address;
}
