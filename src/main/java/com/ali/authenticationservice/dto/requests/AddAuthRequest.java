package com.ali.authenticationservice.dto.requests;

import com.ali.authenticationservice.entities.concretes.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AddAuthRequest {
    @NotNull(message = "Bu alan zorunludur.")
    @Length(min = 3,max = 60,message = "Minimum 3 maximum 60 karakter olmalıdır.")
    private String username;
    @NotNull(message = "Bu alan zorunludur.")
    private String name;
    @NotNull(message = "Bu alan zorunludur.")
    @Length(min = 6,max = 60,message = "Minimum 6 maximum 60 karakter olmalıdır.")
    private String password;

    public User toEntity(AddAuthRequest authRequest){
        return User.builder()
                .name(authRequest.getName())
                .username(authRequest.getPassword())
                .password(authRequest.getPassword())
                .build();
    }
}
