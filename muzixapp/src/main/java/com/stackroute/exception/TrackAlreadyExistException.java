package com.stackroute.exception;

public class TrackAlreadyExistException extends Exception {
    public TrackAlreadyExistException() {}
    public TrackAlreadyExistException(String message) {
        super(message);
    }
}
