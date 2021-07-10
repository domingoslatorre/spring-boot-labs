package com.domingoslatorre.springthymeleafbeanvalidation.signup;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("signup")
@Log
public class SignUpController {
    public static final String SIGNUP_VIEW_NAME = "signup/index";
    public static final String REDIRECT_ROUTE = "redirect:/signin";

    @GetMapping
    public ModelAndView create(SignUpForm signUpForm) {
        ModelAndView mv = new ModelAndView(SIGNUP_VIEW_NAME);
        mv.addObject("languages", FavoriteLanguage.values());
        return mv;
    }

    @PostMapping
    public ModelAndView save(@Valid SignUpForm signUpForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView(SIGNUP_VIEW_NAME);
            mv.addObject("languages", FavoriteLanguage.values());
            return mv;
        }
        log.info(signUpForm.toString());
        return new ModelAndView(REDIRECT_ROUTE);
    }
}
