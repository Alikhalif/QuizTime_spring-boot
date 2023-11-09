package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.dto.SubjectDto;

public interface SubjectService {
    SubjectDto create(SubjectDto subjectDto);
    void delete(Long id);
    SubjectDto getOne(Long id);
}
