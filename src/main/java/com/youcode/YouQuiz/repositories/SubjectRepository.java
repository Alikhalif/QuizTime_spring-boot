package com.youcode.YouQuiz.repositories;

import com.youcode.YouQuiz.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
