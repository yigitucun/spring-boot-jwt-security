package com.ali.authenticationservice.dto.requests;

import com.ali.authenticationservice.entities.concretes.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddRoleRequest {
    @NotBlank(message = "Bu alan zorunludur.")
    private String role;
    public Role toEntity(AddRoleRequest request){
        return Role.builder()
                .role(request.getRole())
                .build();
    }
}
