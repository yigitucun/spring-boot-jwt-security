package com.ali.authenticationservice.core.utils;


import com.ali.authenticationservice.entities.concretes.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    Algorithm algorithm = Algorithm.HMAC256("secret");
    DecodedJWT jwt;
    public String generateToken(User user){
        return JWT.create()
                .withIssuer("auth0")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 50000L))
                .withClaim("username",user.getUsername())
                .withClaim("name",user.getName())
                .withClaim("roles",user.getRoles())
                .sign(algorithm);
    }

    public Claim getClaimFromToken(String from){
        return jwt.getClaim(from);
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
