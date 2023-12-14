package com.ghulam.mitter.system;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Result {
    private boolean flag;
    private Integer code;
    private String message;
    private Object payload;

    public Result(boolean flag, Integer code, String message) {
        this.flag = false;
        this.code = code;
        this.message = message;
    }
}
