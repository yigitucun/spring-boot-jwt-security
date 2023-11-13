package com.ali.authenticationservice.business.abstracts;

import com.ali.authenticationservice.dto.requests.AddAuthRequest;
import com.ali.authenticationservice.dto.requests.AuthRequest;
import com.ali.authenticationservice.dto.responses.TokenResponse;

public interface AuthService {
    AddAuthRequest add(AddAuthRequest request);
    TokenResponse authenticate(AuthRequest request);
}
