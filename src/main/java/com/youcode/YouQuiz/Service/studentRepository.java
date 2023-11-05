package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<Student, Long> {
}
