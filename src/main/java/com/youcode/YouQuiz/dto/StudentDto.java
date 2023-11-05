package com.youcode.youquiz.models.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDto extends UserDto{

    private Long id;
    private LocalDate dateOfInscription;
}
