package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.ImplService.LevelServiceImpl;
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
    private LevelServiceImpl levelServiceImpl;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createLevel(@RequestBody LevelDto levelDto){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("Level", levelServiceImpl.create(levelDto));
            message.put("message", "Level created successfully");
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch (Exception e){
            message.put("erorr", "error in creat level");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllLevel(){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("Levels", levelServiceImpl.getAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "Not found !");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getOneLevel(@PathVariable Long id){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("Level", levelServiceImpl.getOne(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "Not found !");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}

