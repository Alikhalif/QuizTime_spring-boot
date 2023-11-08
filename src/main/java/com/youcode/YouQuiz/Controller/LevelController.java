package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.ImplService.LevelService;
import com.youcode.YouQuiz.dto.LevelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/level")
public class LevelController {

    @Autowired
    private LevelService levelService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createLevel(@RequestBody LevelDto levelDto){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("Level", levelService.create(levelDto));
            message.put("message", "Level created successfully");
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch (Exception e){
            message.put("erorr", "error in creat level");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

    }
}
