package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.ImplService.MediaServiceImpl;
import com.youcode.YouQuiz.Service.MediaService;
import com.youcode.YouQuiz.dto.MediaDto;
import com.youcode.YouQuiz.dto.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/media")
public class MediaController {
    @Autowired
    private MediaServiceImpl mediaService;


    @PostMapping
    public ResponseEntity<Map<String, Object>> createMedia(@RequestBody MediaDto mediaDto){
        Map<String, Object> message = new HashMap<>();
        try{
            mediaService.create(mediaDto);
            message.put("messge", "Media created successfully");
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch (Exception e){
            message.put("error", "Media Not created");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> createMedia(@PathVariable Integer id){
        Map<String, Object> message = new HashMap<>();
        try{
            mediaService.delete(id);
            message.put("messge", "Media deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "Media Not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getOneMedia(@PathVariable Integer id){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("Media", mediaService.getOne(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "Media Not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/question/{id}")
    public ResponseEntity<Map<String, Object>> getMediaByQuestion(@PathVariable Long id){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("Media", mediaService.getByQuestion(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("error", "Media Not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

}
