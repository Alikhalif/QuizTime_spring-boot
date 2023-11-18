package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.AssignQuizService;
import com.youcode.YouQuiz.dto.AnswarDto;
import com.youcode.YouQuiz.dto.AssignQuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Map<String, Object>> createAnswar(@Valid @RequestBody List<AssignQuizDto> assignQuizDtos){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("messge", assignQuizService.create(assignQuizDtos));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch (Exception e){
            message.put("error", "Answar Not created");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
