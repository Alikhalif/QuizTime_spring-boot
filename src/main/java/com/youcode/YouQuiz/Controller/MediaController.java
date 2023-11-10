package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.ImplService.MediaServiceImpl;
import com.youcode.YouQuiz.Service.MediaService;
import com.youcode.YouQuiz.dto.MediaDto;
import com.youcode.YouQuiz.dto.QuestionDto;
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
}
