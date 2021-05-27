package com.project.bootcamp.exceptions;

//Essa classe que acabei de criar é um exeção (RuntimeException diz isso)
public class BusinessException extends RuntimeException {

    public BusinessException(String message){
        super(message);
    }

}
