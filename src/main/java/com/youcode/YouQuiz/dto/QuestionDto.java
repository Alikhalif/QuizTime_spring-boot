package com.youcode.youquiz.models.dto;

import com.youcode.youquiz.models.enums.QuestionType;
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
