package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.ImplService.QuestionServiceImpl;
import com.youcode.YouQuiz.Service.QuestionService;
import com.youcode.YouQuiz.Service.TempoQuizService;
import com.youcode.YouQuiz.dto.QuestionDto;
import com.youcode.YouQuiz.dto.QuizDto;
import com.youcode.YouQuiz.dto.TompQuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private TempoQuizService tempoQuizService;


    @PostMapping
    public ResponseEntity<Map<String, Object>> createQuestion(@Valid @RequestBody QuestionDto questionDto){
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
    public ResponseEntity<Map<String, Object>> updateQuestion(@PathVariable Long id, @Valid @RequestBody QuestionDto questionDto){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("Questions Updated", questionService.update(id, questionDto));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "Question Not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    //temporisation
    @PostMapping("/temp")
    public ResponseEntity<Map<String, Object>> assignTempQuestionToQuiz(@Valid @RequestBody TompQuizDto tompQuizDto){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("temporisation Questions to quiz", tempoQuizService.create(tompQuizDto));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch (Exception e){
            message.put("error", "Question or quiz Not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/temp/{id_quiz}/{id_question}")
    public ResponseEntity<Map<String, Object>> deleteTempQuestionToQuiz(@PathVariable Long id_quiz, @PathVariable Long id_question){
        Map<String, Object> message = new HashMap<>();
        try{
            tempoQuizService.delete(id_quiz, id_question);
            message.put("message", "assign question to quiz deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        }catch (Exception e){
            message.put("error", "Question or quiz Not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
