package com.youcode.YouQuiz.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationDto {
    private Long id;
    private Double points;
    private Boolean checkAnswar;
    private Long question_id;
    private Long answar_id;
}
