package com.ali.authenticationservice.dto.requests;

import com.ali.authenticationservice.entities.concretes.Role;
import lombok.Data;

@Data
public class AddRoleRequest {

    private String role;
    public Role toEntity(AddRoleRequest request){
        return Role.builder()
                .role(request.getRole())
                .build();
    }
}
