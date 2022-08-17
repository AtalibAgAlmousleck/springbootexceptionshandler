package com.codinglevel.spring_relationship.users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handlerException(MethodArgumentNotValidException validException) {
        Map<String, String> errorMap = new HashMap<>();
        validException.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> businessException(UserNotFoundException userNotFoundException) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", userNotFoundException.getMessage());
        return errorMap;
    }
}
