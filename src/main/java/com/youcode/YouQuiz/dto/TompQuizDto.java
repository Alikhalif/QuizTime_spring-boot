package com.youcode.YouQuiz.dto;

import com.youcode.YouQuiz.entities.Question;
import com.youcode.YouQuiz.tool.TempID;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
public class TompQuizDto {
    //private TempID id;

    @NotNull(message = "question id can't be null")
    @Min(value = 1, message = "question id can't be less then 1")
    private Long question_id;

    @NotNull(message = "quiz id can't be null")
    @Min(value = 1, message = "quiz id can't be less then 1")
    private Long quiz_id;

    @NotNull(message = "question time must can't be empty")
    private Integer time;
}
