package com.youcode.YouQuiz.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Person")
public class exempleController {

    @GetMapping("/name")
    public String name(){
        return "ok";
    }

   }
