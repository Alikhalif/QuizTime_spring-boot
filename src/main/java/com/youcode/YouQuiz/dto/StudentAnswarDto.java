package com.youcode.YouQuiz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentAnswarDto {
    private Long id;
    private Long assign_id;
    private Long validation_id;
}
