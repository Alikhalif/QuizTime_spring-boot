package com.youcode.YouQuiz.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationDto {
    private Long id;
    @NotNull(message = "points are required")
    private Double points;
    @NotNull(message = "checkAnswar should not be empty")
    private Boolean checkAnswar;
    private Long question_id;
    private Long answar_id;
}
