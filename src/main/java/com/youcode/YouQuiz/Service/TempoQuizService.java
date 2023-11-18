package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.dto.TompQuizDto;

public interface TempoQuizService {
    TompQuizDto create(TompQuizDto tompQuizDto);
    void delete(Long quiz_id, Long question_id);
    TompQuizDto update(Long quiz_id, Long question_id, TompQuizDto tompQuizDto);
}
