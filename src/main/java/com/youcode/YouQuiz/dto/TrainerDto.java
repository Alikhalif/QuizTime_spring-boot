package com.youcode.YouQuiz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrainerDto extends UserDto{
    private Long id;
    private String speciality;
}
