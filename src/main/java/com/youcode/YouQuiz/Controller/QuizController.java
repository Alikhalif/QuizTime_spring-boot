package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.ImplService.QuizServiceImpl;
import com.youcode.YouQuiz.dto.QuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizServiceImpl quizService;

    @PostMapping
    public ResponseEntity<QuizDto> createQuiz(@RequestBody QuizDto quizDto){
        QuizDto quizCreated = quizService.create(quizDto);
        return new ResponseEntity<>(quizCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id){
        quizService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
