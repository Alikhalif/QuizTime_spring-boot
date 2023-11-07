package com.youcode.YouQuiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AssignQuizDto {
    private Long id;

    private Double score;

    private Double result;

    private String reason;

    private LocalDateTime debutDate;

    private LocalDateTime endDate;
}
