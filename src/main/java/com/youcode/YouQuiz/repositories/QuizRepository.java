package com.youcode.YouQuiz.repositories;

import com.youcode.YouQuiz.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
