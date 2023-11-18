package com.youcode.YouQuiz.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends Exception{
    public EntityNotFoundException(String message){
        super(message);
    }

    public EntityNotFoundException(){
        super("invalid id");
    }
}
