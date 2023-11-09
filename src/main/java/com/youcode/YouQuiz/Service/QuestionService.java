package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.dto.QuestionDto;

import java.util.List;

public interface QuestionService {
    QuestionDto create(QuestionDto questionDto);
    void delete(Long id);
    QuestionDto getOne(Long id);
    List<QuestionDto> getAll();
    QuestionDto update(Long id, QuestionDto questionDto);
}
