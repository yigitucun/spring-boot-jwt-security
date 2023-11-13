package com.ali.authenticationservice.filters;

import com.ali.authenticationservice.core.utils.JwtService;
import com.auth0.jwt.interfaces.Claim;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Service
@AllArgsConstructor
public class Filter extends OncePerRequestFilter {

    private JwtService jwtService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }
        String token = authHeader.substring(7);
        if (!jwtService.validateToken(token)){
            filterChain.doFilter(request,response);
            return;
        }
        Claim username = jwtService.getClaimFromToken("username");
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){

        }
        filterChain.doFilter(request,response);
    }
}























