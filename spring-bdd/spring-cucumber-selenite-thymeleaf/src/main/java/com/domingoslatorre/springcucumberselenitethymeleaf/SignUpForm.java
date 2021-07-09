package com.domingoslatorre.springcucumberselenitethymeleaf;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class SignUpForm {
    @NotNull @NotBlank @Size(min = 3, max = 100)
    private String name;
    @NotNull @NotBlank @Email
    private String email;
    @NotNull @NotBlank @Size(min = 3, max = 20)
    private String password;
    @NotNull @NotBlank @Size(min = 3, max = 20)
    private String passwordConfirmation;
    @NotNull @AssertTrue
    private Boolean acceptedTermsOfUse;
}
