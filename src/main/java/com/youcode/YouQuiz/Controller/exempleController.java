package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.entities.Subject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Person")
public class exempleController {

    @GetMapping("/name")
    public String name(){
        return "ok";
    }

    @PostMapping("/save")
    public ResponseEntity saveSabject(@RequestBody Subject subject){

        return ResponseEntity.ok(subject);
    }
}
