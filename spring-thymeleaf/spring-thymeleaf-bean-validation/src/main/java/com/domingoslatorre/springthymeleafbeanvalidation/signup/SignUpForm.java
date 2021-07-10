package com.domingoslatorre.springthymeleafbeanvalidation.signup;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class SignUpForm {
    @NotNull @NotBlank @Size(min = 2, max = 50)
    private String name;
    @NotNull @NotBlank @Email
    private String email;
    @NotNull @NotBlank @Size(min = 6, max = 20)
    private String password;

    @NotNull
    private FavoriteLanguage favoriteLanguage;

    @NotNull
    private Boolean vehicle1;
    @NotNull
    private Boolean vehicle2;
    @NotNull
    private Boolean vehicle3;

    @Valid @NotNull
    private Colors colors;

}
