package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.dto.TempoResponse.ValidationDtoResponse;
import com.youcode.YouQuiz.dto.ValidationDto;
import com.youcode.YouQuiz.entities.Validation;

import java.util.List;

public interface ValidationServiceImpl {
    ValidationDto create(ValidationDto validationDto);
    List<ValidationDtoResponse> getValidationByQuestion(Long question_id);
}
