package com.ali.authenticationservice.api.controllers;

import com.ali.authenticationservice.business.abstracts.AuthService;
import com.ali.authenticationservice.dto.requests.AddAuthRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthControllers {

    private AuthService authService;
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddAuthRequest request){
        return new ResponseEntity<>(this.authService.add(request), HttpStatus.CREATED);
    }
}
