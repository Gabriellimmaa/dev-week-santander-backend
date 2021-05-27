package com.project.bootcamp.exceptions;

public class ExceptionResponse {

    private String message;

    ExceptionResponse(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
