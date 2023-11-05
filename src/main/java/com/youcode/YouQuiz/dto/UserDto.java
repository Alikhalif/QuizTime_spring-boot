package com.youcode.youquiz.models.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {

    protected String firstName;
    protected String lastName;
    protected LocalDate birthDate;
    protected String address;
}
