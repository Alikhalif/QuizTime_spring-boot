package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.ImplService.QuestionServiceImpl;
import com.youcode.YouQuiz.Service.QuestionService;
import com.youcode.YouQuiz.dto.QuestionDto;
import com.youcode.YouQuiz.dto.QuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @PostMapping
    public ResponseEntity<Map<String, Object>> createQuesion(@RequestBody QuestionDto questionDto){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("New_Question",questionService.create(questionDto));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch (Exception e){
            message.put("error", "Question Not created");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteQuestion(@PathVariable Long id){
        Map<String, Object> message = new HashMap<>();
        try{
            questionService.delete(id);
            message.put("messge", "Question deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "Question Not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getOneQuestion(@PathVariable Long id){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("Question", questionService.getOne(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "Question Not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllQuestion(){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("Questions", questionService.getAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "Question Not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateQuestion(@PathVariable Long id, @RequestBody QuestionDto questionDto){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("Questions Updated", questionService.update(id, questionDto));
            message.put("message", "Question updated successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "Question Not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
