package com.youcode.YouQuiz.repositories;

import com.youcode.YouQuiz.entities.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ValidationRepository extends JpaRepository<Validation, Long> {
    List<Validation> findByQuestionId(Long questionId);

    //@Query("SELECT v FROM Validation v JOIN FETCH v.question q JOIN FETCH v.answar a WHERE q.id = :questionId")
    //List<Validation> findAllDataByQuestionId(Long questionId);

}
