package com.ghulam.microchat.exception;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(String msg) {
        super(msg);
    }
}
