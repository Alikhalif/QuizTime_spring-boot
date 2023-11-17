package com.youcode.YouQuiz.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrainerDto extends UserDto{
    private Long id;
    @NotBlank(message = "speciality should not be empty")
    private String speciality;
}
