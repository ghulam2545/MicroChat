package com.ghulam.microchat.exception;

import com.ghulam.microchat.utils.Result;
import com.ghulam.microchat.utils.StatusCode;
import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomException {

    @ExceptionHandler(UserNotFoundException.class)
    public Result userNotFound(UserNotFoundException ex) {
        return new Result(false, StatusCode.FAIL, ex.getMessage());
    }

    @ExceptionHandler(PostNotFoundException.class)
    public Result postNotFound(PostNotFoundException ex) {
        return new Result(false, StatusCode.FAIL, ex.getMessage());
    }

    @ExceptionHandler(CommentNotFoundException.class)
    public Result commentNotFound(CommentNotFoundException ex) {
        return new Result(false, StatusCode.FAIL, ex.getMessage());
    }

    @ExceptionHandler(CommandAcceptanceException.class)
    public String sqlIssue(CommandAcceptanceException ex) {
        return "some SQL issue";
    }
}
