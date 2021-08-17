package com.test.springtest1.exception;

public class notFoundException extends Exception {

    public notFoundException(String message) {
        super(message);
    }


    protected notFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
