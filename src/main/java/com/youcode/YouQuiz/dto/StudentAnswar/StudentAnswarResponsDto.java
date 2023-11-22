package com.youcode.YouQuiz.dto.StudentAnswar;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentAnswarResponsDto {
    private Long id;
    private Double score;
    private String answarStudent;
    private Double resultFinal;
}
