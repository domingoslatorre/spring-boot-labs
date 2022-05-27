package com.domingoslatorre.springsecurityjwt.security.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JwtProviderImpl implements JwtProvider {
    @Value("$jwt.secret.key")
    private String secretKey;

    @Override
    public String generateToken(UUID userId, String userEmail) {
        return null;
    }

    @Override
    public String getSubjectFromToken(String token) {
        return null;
    }

    @Override
    public boolean validateToken(String token) {
        return false;
    }
}
