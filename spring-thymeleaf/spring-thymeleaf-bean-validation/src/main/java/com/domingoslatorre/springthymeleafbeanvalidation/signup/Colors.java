package com.domingoslatorre.springthymeleafbeanvalidation.signup;

import lombok.Data;

import javax.validation.constraints.AssertTrue;

@Data
public class Colors {
    @AssertTrue
    private boolean green;
    private boolean red;
    private boolean blue;
}
