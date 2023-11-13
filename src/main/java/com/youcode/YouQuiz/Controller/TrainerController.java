package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.ImplService.TrainerServiceImpl;
import com.youcode.YouQuiz.Service.TrainerService;
import com.youcode.YouQuiz.dto.TrainerDto;
import com.youcode.YouQuiz.entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @PostMapping
    public Trainer createTrainer(@RequestBody TrainerDto trainerDto){
        return trainerService.create(trainerDto);
    }

    @GetMapping
    public List<Trainer> getAllTrainer(){
        return trainerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainerDto> getTrainer(@PathVariable Long id){
        TrainerDto trainerDto = trainerService.getOne(id);
        if(trainerDto != null){
            return new ResponseEntity<>(trainerDto, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public Trainer updateTrainer(@PathVariable Long id, @RequestBody TrainerDto trainerDto){
        return trainerService.update(id, trainerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTrainer(@PathVariable Long id){
        trainerService.delete(id);
    }
}
