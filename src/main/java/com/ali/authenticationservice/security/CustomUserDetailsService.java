package com.ali.authenticationservice.security;

import com.ali.authenticationservice.dataAccess.abstracts.IUserRepository;
import com.ali.authenticationservice.entities.concretes.User;
import com.ali.authenticationservice.exceptions.businessException.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if (user == null){
            throw new BusinessException("Kullanıcı adı veya şifre hatalı.", HttpStatus.BAD_REQUEST);
        }
        return user;
    }
}
