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


}
