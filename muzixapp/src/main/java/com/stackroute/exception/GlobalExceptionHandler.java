package com.stackroute.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity<?> trackNotFoundException(TrackNotFoundException ex, WebRequest request) {
        CustomizedErrorResponseStructure errorDetails = new CustomizedErrorResponseStructure(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TrackAlreadyExistException.class)
    public ResponseEntity<?> trackAlreadyExistException(TrackAlreadyExistException ex, WebRequest request) {
        CustomizedErrorResponseStructure errorDetails = new CustomizedErrorResponseStructure(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        CustomizedErrorResponseStructure errorDetails = new CustomizedErrorResponseStructure(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}