package com.ali.authenticationservice.api.controllers;

import com.ali.authenticationservice.business.abstracts.RoleService;
import com.ali.authenticationservice.dto.requests.AddRoleRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RoleController {

    private RoleService roleService;

    @PostMapping
    private ResponseEntity<?> add(@Valid @RequestBody AddRoleRequest request){
        return new ResponseEntity<>(this.roleService.add(request), HttpStatus.CREATED);
    }

}
