package com.stackroute.exception;

public class NameModifiedException extends Exception {
    private String message;
    public NameModifiedException() {}
    public NameModifiedException(String message) {
        super(message);
        this.message = message;
    }
}
