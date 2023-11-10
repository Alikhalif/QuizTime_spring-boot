package com.youcode.YouQuiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswarDto {
    private Long id;
    private String answareText;

    private double points;
    private Boolean checkAnswar;
    private Long question_id;

}
