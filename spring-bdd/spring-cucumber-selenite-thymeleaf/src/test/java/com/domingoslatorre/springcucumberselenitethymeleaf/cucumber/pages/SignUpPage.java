package com.domingoslatorre.springcucumberselenitethymeleaf.cucumber.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SignUpPage {
    public static final String URL = "/signup";

    public SelenideElement setName(String name) {
        return $(By.name("name")).setValue(name);
    }

    public SelenideElement setEmail(String email) {
        return $(By.name("email")).setValue(email);
    }

    public SelenideElement setPassword(String password) {
        return $(By.name("password")).setValue(password);
    }

    public SelenideElement setPasswordConfirmation(String passwordConfirmation) {
        return $(By.name("passwordConfirmation")).setValue(passwordConfirmation);
    }

    public void acceptTermsOfUse() {
        $(By.name("acceptedTermsOfUse")).click();
    }

    public void submit() {
        $(By.name("submit")).click();
    }

    public void redirectToTheHomePage() {
        $(By.tagName("h1")).shouldBe(Condition.text("Home page"));
    }
}
