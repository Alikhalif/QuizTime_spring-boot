package com.youcode.YouQuiz.repositories;

import com.youcode.YouQuiz.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
