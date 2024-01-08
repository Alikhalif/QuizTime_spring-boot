package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.dto.TempoResponse.TempoQuizResponseDto;
import com.youcode.YouQuiz.dto.TompQuizDto;

import java.util.List;

public interface TempoQuizService {
    TompQuizDto create(TompQuizDto tompQuizDto);
    void delete(Long quiz_id, Long question_id);
    TompQuizDto update(Long quiz_id, Long question_id, TompQuizDto tompQuizDto);
    List<TempoQuizResponseDto> findTempoByQuiz(Long quizId);
}
