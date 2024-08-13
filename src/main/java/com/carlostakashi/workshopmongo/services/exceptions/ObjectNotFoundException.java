package com.carlostakashi.workshopmongo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
