package com.youcode.YouQuiz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class QuizDto {
    private long id;
    @NotNull(message = "score is required")
    @Min(value = 0, message = "the minimum passing score is 0")
    private Double score;
    @NotNull(message = "show answers is required")
    private Boolean showAnswers;
    @NotNull(message = "show final results is required")
    private Boolean showFinalResults;
    @NotNull(message = "chance num is required")
    @Min(value = 1, message = "the minimum num of chances is 1")
    private Integer chanceNum;
    private String remark;
    @NotNull(message = "trainer id is required")
    private Long trainerId;
    @NotNull(message = "assignQuizId id is required")
    private Long assignQuizId;
}
