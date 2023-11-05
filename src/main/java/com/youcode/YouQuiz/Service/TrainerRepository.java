package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
