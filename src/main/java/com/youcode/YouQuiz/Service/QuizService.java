package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.dto.QuizDto;

import java.util.List;
import java.util.Optional;

public interface QuizService {
    QuizDto create(QuizDto quizDto);
    QuizDto update(Long id, QuizDto quizDto);
    void delete(Long id);
    List<QuizDto> getAll();
    Optional<QuizDto> getOne(Long id);
}
