package com.youcode.YouQuiz.repositories;

import com.youcode.YouQuiz.entities.AssignQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignQuizRepository extends JpaRepository<AssignQuiz, Long> {
    List<AssignQuiz> findByStudentId(Long studentId);
}
