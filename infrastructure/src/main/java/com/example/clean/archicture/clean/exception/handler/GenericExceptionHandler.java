package com.example.clean.archicture.clean.exception.handler;

import com.example.clean.archicture.clean.exception.ExceptionResponse;
import com.example.clean.archicture.clean.exception.GenericException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ExceptionResponse> customExceptionHandler(GenericException exception) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .code(exception.getStatus().value() + " " + exception.getStatus().name())
                .message(exception.getMessage()).build();
        ResponseEntity<ExceptionResponse> response = new ResponseEntity<>(exceptionResponse, exception.getStatus());
        return response;
    }

}
