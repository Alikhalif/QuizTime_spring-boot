package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.entities.TempoQuiz;
import com.youcode.YouQuiz.entities.TempID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempQuizRepository extends JpaRepository<TempoQuiz, TempID> {
}
