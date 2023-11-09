package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.dto.SubjectDto;

import java.util.List;

public interface SubjectService {
    SubjectDto create(SubjectDto subjectDto);
    void delete(Long id);
    SubjectDto getOne(Long id);
    List<SubjectDto> getAll();
}
