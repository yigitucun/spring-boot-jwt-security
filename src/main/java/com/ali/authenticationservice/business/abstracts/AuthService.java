package com.ali.authenticationservice.business.abstracts;

import com.ali.authenticationservice.dto.requests.AddAuthRequest;
import com.ali.authenticationservice.dto.requests.AuthRequest;
import com.ali.authenticationservice.dto.responses.ListUsersResponse;
import com.ali.authenticationservice.dto.responses.TokenResponse;

import java.util.List;

public interface AuthService {
    AddAuthRequest add(AddAuthRequest request);
    TokenResponse authenticate(AuthRequest request);
    List<ListUsersResponse> getUsers();
}
