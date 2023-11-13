package com.ali.authenticationservice.exceptions.validationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class ValidationExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ValidationExceptionDetails> handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
        ValidationExceptionDetails exceptionDetails = new ValidationExceptionDetails();
        exceptionDetails.setTimestamp(System.currentTimeMillis());
        exceptionDetails.setCode(HttpStatus.BAD_REQUEST.value());
        exceptionDetails.setValidationErrors(new HashMap<>());
        for (FieldError fieldError:methodArgumentNotValidException.getBindingResult().getFieldErrors()){
            exceptionDetails.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }
}
