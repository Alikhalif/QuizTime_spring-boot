package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.dto.StudentAnswar.StudentAnswarResponsDto;
import com.youcode.YouQuiz.dto.StudentAnswarDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentAnswarService{
    StudentAnswarDto create(StudentAnswarDto studentAnswarDto);
    List<StudentAnswarResponsDto> getAllAnswarOfStudent(Long assign_id);
}
