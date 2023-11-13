package com.ali.authenticationservice.core.utils;


import com.ali.authenticationservice.entities.concretes.Role;
import com.ali.authenticationservice.entities.concretes.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtService {
    Algorithm algorithm = Algorithm.HMAC256("secret");
    public String generateToken(User user){
        Date now = new Date();
        return JWT.create()
                .withIssuer("auth0")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(now.getTime() + 2 * 60 * 60 * 1000))
                .withClaim("username",user.getUsername())
                .withClaim("name",user.getName())
                .withClaim("roles",user.getRoles().stream().map(Role::getRole).collect(Collectors.toList()))
                .sign(algorithm);
    }

    public Claim getClaimFromToken(String token,String from){
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaim(from);
    }
    public boolean validateToken(String token){
        try{
            JWTVerifier verifier = JWT.require(algorithm).withIssuer("auth0").build();
            verifier.verify(token);
            return true;
        }catch (JWTVerificationException e){
            return false;
        }
    }

}
