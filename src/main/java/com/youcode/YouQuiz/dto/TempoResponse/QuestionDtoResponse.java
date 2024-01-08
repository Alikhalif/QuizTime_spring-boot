package com.youcode.YouQuiz.dto.TempoResponse;

import com.youcode.YouQuiz.dto.LevelDto;
import com.youcode.YouQuiz.dto.MediaDto;
import com.youcode.YouQuiz.dto.SubjectDto;
import com.youcode.YouQuiz.enums.QuestionType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class QuestionDtoResponse {
    private Long id;
    @NotBlank(message = "question content should not be empty")
    private String questionText;
    @NotNull(message = "question type is required")
    private QuestionType type;
    @Min(value = 0, message = "total score can't be less than 0")
    private Double totalScore;
    private SubjectDto subject;
    private LevelDto level;
    private List<MediaDto> medias;
}
