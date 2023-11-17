package com.youcode.YouQuiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswarDto {
    private Long id;
    @NotBlank(message = "the response require a non empty string")
    private String answareText;
    @Min(value = 0, message = "the point can't be less then 0")
    private double points;
    @NotNull(message = "checkAnswar can't be null")
    private Boolean checkAnswar;
    @Min(value = 0, message = "invalid question id")
    @NotNull(message = "response require question id")
    private Long question_id;

}
