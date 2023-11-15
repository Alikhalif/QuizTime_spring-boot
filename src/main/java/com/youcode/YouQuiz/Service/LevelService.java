package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.Exception.EntityNotFoundException;
import com.youcode.YouQuiz.dto.LevelDto;

import java.util.List;
import java.util.Optional;

public interface LevelService {
    LevelDto create(LevelDto levelDto);
    List<LevelDto> getAll();
    LevelDto getOne(Long id) throws EntityNotFoundException;
    void delete(Long id) throws EntityNotFoundException;
    LevelDto update(Long id, LevelDto levelDto);
}
