package com.mehdilagdimi.itsgovfinanceservice.security;//package com.mehdilagdimi.itsgovauthservice.security;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("auth-service")
    private String service_url;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("AUTHORIZATION");
        final String userEmail;
        final String token;
        final boolean isTokenValid;

        ResponseEntity<HttpServletRequest> authRequestResponseEntity = restTemplate.getForEntity(service_url, HttpServletRequest.class);

        filterChain.doFilter(request,response);
    }
}
