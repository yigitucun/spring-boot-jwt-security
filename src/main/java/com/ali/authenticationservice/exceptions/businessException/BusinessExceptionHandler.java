package com.ali.authenticationservice.exceptions.businessException;


import com.ali.authenticationservice.exceptions.ExceptionDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BusinessExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionDetails> handleBusinessException(BusinessException businessException){
        ExceptionDetails exceptionDetails = new ExceptionDetails();
        exceptionDetails.setMessage(businessException.getMessage());
        exceptionDetails.setTimestamp(System.currentTimeMillis());
        exceptionDetails.setCode(businessException.getHttpStatus().value());
        return new ResponseEntity<>(exceptionDetails,businessException.getHttpStatus());
    }
}
