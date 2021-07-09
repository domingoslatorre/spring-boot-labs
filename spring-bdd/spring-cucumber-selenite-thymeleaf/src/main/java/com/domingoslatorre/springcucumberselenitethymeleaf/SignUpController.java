package com.domingoslatorre.springcucumberselenitethymeleaf;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("signup")
@AllArgsConstructor
public class SignUpController {
    private static final String SIGNUP_VIEW_NAME = "signup/index";
    private static final String REDIRECT_ROUTE = "redirect:/";
    private UserRepository userRepository;

    @GetMapping()
    public ModelAndView create(SignUpForm signUpForm) {
        return new ModelAndView(SIGNUP_VIEW_NAME);
    }

    @PostMapping
    public ModelAndView save(@Valid SignUpForm signUpForm, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView(SIGNUP_VIEW_NAME);
        }
        // keeping the focus on the lab, no mappers, services or password hashing
        User user = new User(signUpForm.getName(), signUpForm.getEmail(), signUpForm.getPassword());
        userRepository.save(user);
        return new ModelAndView(REDIRECT_ROUTE);
    }
}
