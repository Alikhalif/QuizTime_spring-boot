package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.SubjectService;
import com.youcode.YouQuiz.dto.SubjectDto;
import com.youcode.YouQuiz.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createSubject(@RequestBody SubjectDto subjectDto){
        Map<String, Object> message = new HashMap<>();
        try {
            message.put("Subject", subjectService.create(subjectDto));
            message.put("message", "Subject created successfully");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            message.put("error", "Error in create subject ! ");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteSubject(@PathVariable Long id){
        Map<String, Object> message = new HashMap<>();
        try {
            subjectService.delete(id);
            message.put("message", "Subject deleted successfully");
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "Error in delete subject ! ");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}