package com.example.clean.archicture.clean.exception.handler;

import com.example.clean.archicture.clean.exception.ExceptionResponse;
import com.example.clean.archicture.clean.exception.GenericException;
import com.example.clean.archicture.pichincha.exception.ClientException;
import org.springframework.http.HttpStatus;
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

    @ExceptionHandler(ClientException.class)
    public ResponseEntity<ExceptionResponse> clientExceptionResponse(ClientException exception) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value() + " " + HttpStatus.BAD_REQUEST.name())
                .message(exception.getMessage()).build();
        ResponseEntity<ExceptionResponse> response = new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
        return response;
    }
}
