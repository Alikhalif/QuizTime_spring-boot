package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.AssignQuizService;
import com.youcode.YouQuiz.dto.AnswarDto;
import com.youcode.YouQuiz.dto.AssignQuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/assign_quiz")
public class AssignQuizController {
    @Autowired
    private AssignQuizService assignQuizService;


    @PostMapping
    public ResponseEntity<Map<String, Object>> assignQuiz(@Valid @RequestBody List<AssignQuizDto> assignQuizDtos){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", assignQuizService.create(assignQuizDtos));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch (Exception e){
            message.put("error", "not assign Quiz");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteassignQuiz(@PathVariable Long id){
        Map<String, Object> message = new HashMap<>();
        try{
            assignQuizService.delete(id);
            message.put("message", "deleted successfuly");
            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        }catch (Exception e){
            //message.put("error", "assign Quiz not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }


    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllAssignQuizzes(){
        Map<String, Object> message = new HashMap<>();
        try{

            message.put("all assignements", assignQuizService.getAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getOneAssignQuizzes(@PathVariable Long id){
        Map<String, Object> message = new HashMap<>();
        try{

            message.put("message", assignQuizService.getOne(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "assign Quiz not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
