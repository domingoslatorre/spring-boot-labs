package com.domingoslatorre.springcucumberselenitethymeleaf.cucumber.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public static final String URL = "/";

    public SelenideElement getSignUpLink() {
        return $(By.id("signup-link"));
    }
}
