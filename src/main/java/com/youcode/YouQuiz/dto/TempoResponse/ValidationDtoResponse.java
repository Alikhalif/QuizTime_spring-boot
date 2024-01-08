package com.youcode.YouQuiz.dto.TempoResponse;

import com.youcode.YouQuiz.dto.AnswarDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationDtoResponse {
    private Long id;
    private QuestionDtoResponse question;
    private AnswarDtoResponse answar;
    private Double points;
    private Boolean checkAnswar;

}
