package com.domingoslatorre.springsecurityjwt.user;

import java.util.UUID;

public record UserDto(UUID id, String name, String email, String role, Boolean active) {
}
