package com.ali.authenticationservice.dto.responses;

import lombok.Data;

@Data
public class TokenResponse {
    private String token;
    private int code = 201;
}
