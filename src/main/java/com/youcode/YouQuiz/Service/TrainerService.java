package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.dto.TrainerDto;
import com.youcode.YouQuiz.entities.Trainer;

public interface TrainerService {
    Trainer create(TrainerDto trainerDto);
}
