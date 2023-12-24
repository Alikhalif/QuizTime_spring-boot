package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.ImplService.TrainerServiceImpl;
import com.youcode.YouQuiz.Service.TrainerService;
import com.youcode.YouQuiz.dto.TrainerDto;
import com.youcode.YouQuiz.entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @PostMapping
    public Trainer createTrainer(@Valid @RequestBody TrainerDto trainerDto){
        return trainerService.create(trainerDto);
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllTrainer(){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("Trainers", trainerService.getAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "Not found !");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getTrainer(@PathVariable Long id){
        Map<String, Object> message = new HashMap<>();

        try {
            message.put("trainer", trainerService.getOne(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "Not found !");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public Trainer updateTrainer(@PathVariable Long id, @Valid @RequestBody TrainerDto trainerDto){
        return trainerService.update(id, trainerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTrainer(@PathVariable Long id){
        trainerService.delete(id);
    }


    @GetMapping("/find/{page}")
    public ResponseEntity<List<TrainerDto>> findTrainerByLimit(@PathVariable int page){
        List<TrainerDto> trainers = trainerService.findByLimit(page);
        return ResponseEntity.ok(trainers);
    }
}
