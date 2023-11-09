package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.dto.TrainerDto;
import com.youcode.YouQuiz.entities.Trainer;

import java.util.List;

public interface TrainerService {
    Trainer create(TrainerDto trainerDto);
    List<Trainer> getAll();
    TrainerDto getOne(Long id);
    Trainer update(Long id, TrainerDto trainerDto);
    void delete(Long id);
}
