package com.youcode.YouQuiz.Exception;

public class EntityNotFoundException extends Exception{
    public EntityNotFoundException(String message){
        super(message);
    }

    public EntityNotFoundException(){
        super("invalid id");
    }
}
