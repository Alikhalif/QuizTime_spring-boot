package com.youcode.YouQuiz.repositories;

import com.youcode.YouQuiz.entities.StudentAnswar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentAnswarRepository extends JpaRepository<StudentAnswar, Long> {
    int countStudentAnswarByValidationIdAndAndAssignQuiz_Id(Long validation_id, Long assign_id);
    List<StudentAnswar> findByAssignQuizId(Long assignQuizId);
}
