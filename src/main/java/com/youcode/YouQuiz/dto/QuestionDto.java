package com.youcode.YouQuiz.dto;

import com.youcode.YouQuiz.enums.QuestionType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionDto {
    private Long id;
    private String questionText;
    private QuestionType type;
    private Double totalScore;
}
