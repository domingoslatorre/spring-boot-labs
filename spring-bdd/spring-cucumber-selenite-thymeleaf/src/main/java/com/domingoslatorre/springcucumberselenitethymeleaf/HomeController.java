package com.domingoslatorre.springcucumberselenitethymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    public static final String HOME_VIEW_NAME = "index";

    @GetMapping
    public String home() {
        return HOME_VIEW_NAME;
    }
}
