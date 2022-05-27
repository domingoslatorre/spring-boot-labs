package com.domingoslatorre.springsecurityjwt.security.services;

import java.util.UUID;

public interface JwtProvider {
    String generateToken(UUID userId, String userEmail);
    String getSubjectFromToken(String token);
    boolean validateToken(String token);
}
