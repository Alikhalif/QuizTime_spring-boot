package com.youcode.youquiz.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuizDto {

    private Long id;
    private Double score;
    private Boolean showAnswers;
    private Boolean showFinalResults;
    private Integer chanceNum;
    private String remark;
}
