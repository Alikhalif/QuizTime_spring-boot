package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.AnswarService;
import com.youcode.YouQuiz.Service.ImplService.AnswarServiceImpl;
import com.youcode.YouQuiz.dto.AnswarDto;
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
@RequestMapping("/api/answar")
public class AnswarController {
    @Autowired
    private AnswarServiceImpl answarService;


    //@PostMapping
    //public ResponseEntity<Map<String, Object>> createAnswar(@RequestBody AnswarDto answarDto){
        //Map<String, Object> message = new HashMap<>();
        //try{
            //answarService.create(answarDto);
            //message.put("messge", "Answar created successfully");
            //return new ResponseEntity<>(message, HttpStatus.CREATED);
        //}catch (Exception e){
            //message.put("error", "Answar Not created");
            //return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        //}

    //}

    @PostMapping
    public AnswarDto createAnswar(@RequestBody AnswarDto answarDto){

            return answarService.create(answarDto);


    }
}
