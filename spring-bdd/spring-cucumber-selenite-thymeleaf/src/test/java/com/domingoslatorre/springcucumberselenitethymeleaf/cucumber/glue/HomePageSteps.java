package com.domingoslatorre.springcucumberselenitethymeleaf.cucumber.glue;

import com.codeborne.selenide.Condition;
import com.domingoslatorre.springcucumberselenitethymeleaf.cucumber.pages.HomePage;
import com.domingoslatorre.springcucumberselenitethymeleaf.cucumber.pages.SignUpPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;

public class HomePageSteps  {
    private HomePage homePage;

    @Given("^I am on home page$")
    public void IamOnSignUpForm() {
        homePage = open(HomePage.URL, HomePage.class);
        screenshot(HomePage.class.getSimpleName() + "before");
    }

    @Then("^I should see the sign up link$")
    public void IShouldBeRedirectedToTheHomePage() {
        homePage.getSignUpLink()
          .shouldBe(Condition.visible)
          .shouldHave(Condition.href(SignUpPage.URL))
          .shouldBe(Condition.text("Sign Up"));
    }
}


