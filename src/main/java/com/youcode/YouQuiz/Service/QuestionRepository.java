package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
