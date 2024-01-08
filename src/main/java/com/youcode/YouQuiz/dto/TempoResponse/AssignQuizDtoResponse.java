package com.youcode.YouQuiz.dto.TempoResponse;

import com.youcode.YouQuiz.dto.QuizDto;
import com.youcode.YouQuiz.dto.StudentDto;
import com.youcode.YouQuiz.entities.Quiz;
import com.youcode.YouQuiz.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignQuizDtoResponse {
    private Long id;
    @Min(value = 0, message = "score can't be negative")
    private Double score;
    private Double result;

    private String reason;
    @NotNull(message = "debut date can't be null")
    private LocalDateTime debutDate;
    @NotNull(message = "end date can't be null")
    private LocalDateTime endDate;
    private StudentDto student;
    private QuizDto quiz;
}
