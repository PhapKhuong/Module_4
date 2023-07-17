package com.libraries.exception;

public class OffBookException extends RuntimeException {
    public OffBookException(String message) {
        super(message);
    }
}
