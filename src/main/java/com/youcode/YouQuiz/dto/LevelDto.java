package com.youcode.YouQuiz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class LevelDto {
    private Long id;
    @NotBlank(message = "description can't be null")
    private String description;
    @NotNull(message = "maxScore can't be null")
    @Min(value = 0, message = "the minimum value is 0")
    private Double maxScore;
    @NotNull(message = "minScore can't be null")
    @Min(value = 0, message = "the minimum value is 0")
    private Double minScore;
}
