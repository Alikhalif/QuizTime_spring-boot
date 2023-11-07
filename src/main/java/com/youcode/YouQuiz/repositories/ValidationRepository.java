package com.youcode.YouQuiz.repositories;

import com.youcode.YouQuiz.entities.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationRepository extends JpaRepository<Validation, Long> {
}
