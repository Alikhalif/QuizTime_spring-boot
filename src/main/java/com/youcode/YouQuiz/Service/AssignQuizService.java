package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.dto.AssignQuizDto;

import java.util.List;

public interface AssignQuizService {
    List<AssignQuizDto> create(List<AssignQuizDto> assignQuizDtos);
}
