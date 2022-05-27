package com.domingoslatorre.springsecurityjwt.user;

public record UserCreateDto(String name, String email, String password, String role) {
}
