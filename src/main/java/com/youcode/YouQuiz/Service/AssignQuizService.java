package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.dto.AssignQuizDto;
import com.youcode.YouQuiz.dto.TempoResponse.AssignQuizDtoResponse;

import java.util.List;

public interface AssignQuizService {
    List<AssignQuizDto> create(List<AssignQuizDto> assignQuizDtos);
    void delete(Long id);
    List<AssignQuizDto> getAll();
    AssignQuizDtoResponse getOne(Long id);
    AssignQuizDto update(Long id, AssignQuizDto assignQuizDto);
    List<AssignQuizDto> getByStudent(Long studentId);
}
