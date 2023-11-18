package com.youcode.YouQuiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AssignQuizDto {
    private Long id;
    @Min(value = 0, message = "score can't be negative")
    private Double score;
    private Double result;

    private String reason;
    @NotNull(message = "debut date can't be null")
    private LocalDateTime debutDate;
    @NotNull(message = "end date can't be null")
    private LocalDateTime endDate;
    private Long student_id;
    private Long quiz_id;
}
