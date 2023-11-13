package com.ali.authenticationservice.business.concretes;

import com.ali.authenticationservice.business.abstracts.AuthService;
import com.ali.authenticationservice.business.rules.UserBusinessRules;
import com.ali.authenticationservice.dataAccess.abstracts.IUserRepository;
import com.ali.authenticationservice.dto.requests.AddAuthRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthManager  implements AuthService {

    private IUserRepository userRepository;
    private UserBusinessRules userBusinessRules;
    private PasswordEncoder encoder;

    @Override
    public AddAuthRequest add(AddAuthRequest request) {
        this.userBusinessRules.checkIfUserUsername(request.getUsername());
        request.setPassword(encoder.encode(request.getPassword()));
        this.userRepository.save(request.toEntity(request));
        return request;
    }
}
