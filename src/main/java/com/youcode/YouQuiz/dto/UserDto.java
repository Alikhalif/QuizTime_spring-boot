package com.youcode.YouQuiz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserDto {
    protected String firstName;
    protected String lastName;
    protected LocalDate birthDate;
    protected String address;
}
