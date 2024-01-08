package com.youcode.YouQuiz.repositories;

import com.youcode.YouQuiz.entities.TompQuiz;
import com.youcode.YouQuiz.tool.TempID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TompQuizRepository extends JpaRepository<TompQuiz, TempID> {
    List<TompQuiz> findByQuizId(Long quizId);
}
