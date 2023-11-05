package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.entities.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level, Long> {
}
