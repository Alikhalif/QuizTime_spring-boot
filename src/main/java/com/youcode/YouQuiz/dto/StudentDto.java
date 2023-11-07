package com.youcode.YouQuiz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class StudentDto extends UserDto{
    private Long id;
    private LocalDate dateInscription;
}
