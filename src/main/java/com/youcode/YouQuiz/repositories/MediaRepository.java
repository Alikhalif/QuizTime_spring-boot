package com.youcode.YouQuiz.repositories;

import com.youcode.YouQuiz.entities.Media;
import com.youcode.YouQuiz.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Integer> {
    Media findByQuestion(Question question);
}
