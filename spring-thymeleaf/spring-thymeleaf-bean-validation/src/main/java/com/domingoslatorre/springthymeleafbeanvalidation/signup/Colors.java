package com.domingoslatorre.springthymeleafbeanvalidation.signup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Colors {
    @AssertTrue
    private boolean green = false;
    private boolean red = false;
    private boolean blue = false;
}
