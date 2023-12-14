package com.ghulam.mitter.exception;

import com.ghulam.mitter.system.Result;
import com.ghulam.mitter.system.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public Result userNotFoundException(UserNotFoundException ex) {
        return new Result(false, StatusCode.NOT_FOUND, "user not found");
    }
}
