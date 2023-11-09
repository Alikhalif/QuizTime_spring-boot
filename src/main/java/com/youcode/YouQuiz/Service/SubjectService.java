package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.dto.SubjectDto;

public interface SubjectService {
    SubjectDto create(SubjectDto subjectDto);
    public void delete(Long id);
}
