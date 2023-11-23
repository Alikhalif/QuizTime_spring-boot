package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.Exception.EntityNotFoundException;
import com.youcode.YouQuiz.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto create(StudentDto studentDto);
    List<StudentDto> getAll();
    StudentDto getOne(Long id);
    StudentDto update(Long id, StudentDto studentDto) throws EntityNotFoundException;
    void delete(Long id);
    List<StudentDto> findByLimit(int pageNbr);
}
