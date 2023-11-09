package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.dto.LevelDto;

import java.util.List;
import java.util.Optional;

public interface LevelService {
    LevelDto create(LevelDto levelDto);
    List<LevelDto> getAll();
    Optional<LevelDto> getOne(Long id);
    void delete(Long id);
    LevelDto update(Long id, LevelDto levelDto);
}
