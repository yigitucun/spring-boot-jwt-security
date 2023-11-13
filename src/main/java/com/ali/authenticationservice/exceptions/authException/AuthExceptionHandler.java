package com.ali.authenticationservice.exceptions.authException;

import com.ali.authenticationservice.exceptions.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> handleAuthException(BadCredentialsException e){
        ExceptionDetails exceptionDetails = new ExceptionDetails();
        exceptionDetails.setMessage("Kullanıcı adı veya şifre hatalı.");
        exceptionDetails.setCode(HttpStatus.BAD_REQUEST.value());
        exceptionDetails.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(exceptionDetails,HttpStatus.BAD_REQUEST);
    }
}
