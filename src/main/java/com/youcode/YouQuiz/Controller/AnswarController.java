package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.AnswarService;
import com.youcode.YouQuiz.Service.ImplService.AnswarServiceImpl;
import com.youcode.YouQuiz.dto.AnswarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/answar")
public class AnswarController {
    @Autowired
    private AnswarService answarService;


    @PostMapping
    public ResponseEntity<Map<String, Object>> createAnswar(@Valid @RequestBody AnswarDto answarDto){
        Map<String, Object> message = new HashMap<>();
        try{
            answarService.create(answarDto);
            message.put("messge", "Answar created successfully");
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch (Exception e){
            message.put("error", "Answar Not created");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }


    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllAnswar(){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("Answars", answarService.getAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "Answars Not Found !");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getOneAnswar(@PathVariable Long id){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("Answar", answarService.getOne(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "Answar Not Found with id : "+id);
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteAnswar(@PathVariable Long id){
        Map<String, Object> message = new HashMap<>();
        try{
            answarService.delete(id);
            message.put("message","answar deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "Answar Not Found with id : "+id);
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateAnswar(@PathVariable Long id, @Valid @RequestBody AnswarDto answarDto){
        Map<String, Object> message = new HashMap<>();
        try{
            answarService.update(id,answarDto);
            message.put("message","answar update successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "Answar Not Found with id : "+id);
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
