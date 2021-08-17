package com.test.springtest1.exception;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(int id) {
        super("No record found for id " + id);
    }
}
