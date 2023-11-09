package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.ImplService.QuestionServiceImpl;
import com.youcode.YouQuiz.dto.QuestionDto;
import com.youcode.YouQuiz.dto.QuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionServiceImpl questionService;


    @PostMapping
    public ResponseEntity<Map<String, Object>> createQuesion(@RequestBody QuestionDto questionDto){
        Map<String, Object> message = new HashMap<>();
        try{
            questionService.create(questionDto);
            message.put("messge", "Question created successfully");
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch (Exception e){
            message.put("error", "Question Not created");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
