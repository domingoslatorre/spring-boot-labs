package com.domingoslatorre.springsecurityjwt.user;

import java.util.UUID;

public record UserDto(UUID id, String email, String name, Boolean active) {
}
