package com.youcode.YouQuiz.repositories;

import com.youcode.YouQuiz.entities.Answar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswarRepository extends JpaRepository<Answar, Long> {


}
