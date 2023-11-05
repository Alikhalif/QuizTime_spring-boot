package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.entities.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<Response, Long> {
}
