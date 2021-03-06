package com.domingoslatorre.springthymeleafbeanvalidation.signin;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SignInForm {
    @NotNull @NotBlank @Email
    private String email;
    @NotNull @NotBlank
    private String password;
}
