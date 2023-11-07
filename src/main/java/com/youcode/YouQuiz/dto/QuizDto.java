package com.youcode.YouQuiz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuizDto {
    private long id;
    private Double score;
    private Boolean showAnswers;
    private Boolean showFinalResults;
    private Integer chanceNum;
    private String remark;
}
