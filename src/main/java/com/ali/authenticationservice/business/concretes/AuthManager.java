package com.ali.authenticationservice.business.concretes;

import com.ali.authenticationservice.business.abstracts.AuthService;
import com.ali.authenticationservice.business.rules.UserBusinessRules;
import com.ali.authenticationservice.core.utils.JwtService;
import com.ali.authenticationservice.dataAccess.abstracts.IUserRepository;
import com.ali.authenticationservice.dto.requests.AddAuthRequest;
import com.ali.authenticationservice.dto.requests.AuthRequest;
import com.ali.authenticationservice.dto.responses.ListUsersResponse;
import com.ali.authenticationservice.dto.responses.TokenResponse;
import com.ali.authenticationservice.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthManager  implements AuthService {

    private IUserRepository userRepository;
    private UserBusinessRules userBusinessRules;
    private PasswordEncoder encoder;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @Override
    public AddAuthRequest add(AddAuthRequest request) {
        this.userBusinessRules.checkIfUserUsername(request.getUsername());
        request.setPassword(encoder.encode(request.getPassword()));
        this.userRepository.save(request.toEntity(request));
        return request;
    }

    @Override
    public TokenResponse authenticate(AuthRequest request) {
        User user = this.userRepository.findByUsername(request.getUsername());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        String token = jwtService.generateToken(user);
        TokenResponse response = new TokenResponse();
        response.setToken(token);
        return response;
    }

    @Override
    public List<ListUsersResponse> getUsers() {
        List<User> users = this.userRepository.findAll();
        return ListUsersResponse.toEntity(users);
    }
}


















