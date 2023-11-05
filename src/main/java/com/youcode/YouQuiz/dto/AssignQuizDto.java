package com.youcode.youquiz.models.dto;

import com.youcode.youquiz.models.entities.Quiz;
import com.youcode.youquiz.models.entities.Student;
import lombok.Data;

@Data
public class AssignQuizDto {

    private Long id;
    private Double score;
    private Integer played;
    private Double result;
    private Student student;
    private Quiz quiz;
}
