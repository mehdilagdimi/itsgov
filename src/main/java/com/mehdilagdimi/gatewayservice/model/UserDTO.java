package com.mehdilagdimi.gatewayservice.model;



import java.util.List;


public record UserDTO (Long id,
                       String username,
                       String email,
                       String password,
                       Boolean isExpired,
                       Boolean isLocked,
                       Boolean isCredentialsNonExpired,
                       Boolean isEnabled,
                       List<String> roles
       ) { }
