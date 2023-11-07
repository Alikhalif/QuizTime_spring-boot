package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.ImplService.TrainerServiceImpl;
import com.youcode.YouQuiz.Service.TrainerService;
import com.youcode.YouQuiz.dto.TrainerDto;
import com.youcode.YouQuiz.entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    @Autowired
    private TrainerServiceImpl trainerService;

    @PostMapping
    private Trainer createTrainer(@RequestBody TrainerDto trainerDto){
        return trainerService.create(trainerDto);
    }
}
