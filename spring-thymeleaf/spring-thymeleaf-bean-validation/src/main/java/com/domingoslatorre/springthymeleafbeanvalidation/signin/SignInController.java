package com.domingoslatorre.springthymeleafbeanvalidation.signin;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("signin")
@Log
public class SignInController {
    public static final String SIGNIN_VIEW_NAME = "signin/index";
    public static final String REDIRECT_ROUTE = "redirect:/";

    @GetMapping
    public ModelAndView create(SignInForm signInForm) {
        return new ModelAndView(SIGNIN_VIEW_NAME);
    }

    @PostMapping
    public ModelAndView save(@Valid SignInForm signInForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView(SIGNIN_VIEW_NAME);
        }
        log.info(signInForm.toString());
        return new ModelAndView(REDIRECT_ROUTE);
    }
}
