package com.ali.authenticationservice.business.rules;

import com.ali.authenticationservice.dataAccess.abstracts.IUserRepository;
import com.ali.authenticationservice.exceptions.businessException.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRules {

    private IUserRepository userRepository;
    public void checkIfUserUsername(String username){
        if (this.userRepository.existsByUsername(username)){
            throw new BusinessException("Kullanıcı adı önceden alınmış.", HttpStatus.BAD_REQUEST);
        }
    }
}
