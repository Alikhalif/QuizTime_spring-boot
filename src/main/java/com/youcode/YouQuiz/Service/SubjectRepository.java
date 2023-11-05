package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
