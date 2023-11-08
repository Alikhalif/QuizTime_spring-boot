package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.ImplService.QuizServiceImpl;
import com.youcode.YouQuiz.dto.QuizDto;
import com.youcode.YouQuiz.dto.StudentDto;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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


    @PutMapping("/{id}")
    public ResponseEntity<QuizDto> updateQuiz(@PathVariable Long id, @RequestBody QuizDto quizDto){
        QuizDto quizDto1 = quizService.update(id,quizDto);
        if(quizDto1 != null){
            return new ResponseEntity<>(quizDto1, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id){
        quizService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllQuiz(){
        Map<String, Object> message = new HashMap<>();
        try {
            message.put("Quizess", quizService.getAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("erorr", "Not Found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getOneQuiz(@PathVariable Long id){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("Quiz", quizService.getOne(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("erorr", "Quiz not found with id "+id);
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
