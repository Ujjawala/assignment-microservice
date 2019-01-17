package com.stackroute.exception;

public class TrackNotFoundException extends Exception {
    public TrackNotFoundException() {}
    public TrackNotFoundException(String message) {
        super(message);
    }
}
