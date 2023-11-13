package com.ali.authenticationservice.business.abstracts;

import com.ali.authenticationservice.dto.requests.AddAuthRequest;

public interface AuthService {
    AddAuthRequest add(AddAuthRequest request);
}
