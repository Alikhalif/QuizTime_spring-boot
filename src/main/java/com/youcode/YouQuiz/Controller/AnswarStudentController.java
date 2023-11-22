package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.StudentAnswarService;
import com.youcode.YouQuiz.dto.StudentAnswarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/answar_student")
public class AnswarStudentController {
    @Autowired
    private StudentAnswarService studentAnswarService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody StudentAnswarDto studentAnswarDto){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", studentAnswarService.create(studentAnswarDto));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch (Exception e){
            message.put("error", "not answar");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }


    @GetMapping("/{assign_id}")
    public ResponseEntity<Map<String, Object>> getAllAnswarOfStudent(@PathVariable Long assign_id){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("List student answar", studentAnswarService.getAllAnswarOfStudent(assign_id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "not answar of student");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
