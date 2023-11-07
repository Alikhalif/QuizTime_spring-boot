package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.ImplService.TrainerServiceImpl;
import com.youcode.YouQuiz.Service.TrainerService;
import com.youcode.YouQuiz.dto.TrainerDto;
import com.youcode.YouQuiz.entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    @Autowired
    private TrainerServiceImpl trainerService;

    @PostMapping
    public Trainer createTrainer(@RequestBody TrainerDto trainerDto){
        return trainerService.create(trainerDto);
    }

    @GetMapping
    public List<Trainer> getAllTrainer(){
        return trainerService.getAll();
    }

    @PutMapping("/{id}")
    public Trainer updateTrainer(@PathVariable Long id, @RequestBody TrainerDto trainerDto){
        return trainerService.update(id, trainerDto);
    }
}
