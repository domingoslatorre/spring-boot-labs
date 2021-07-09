package com.domingoslatorre.springcucumberselenitethymeleaf.cucumber.glue;

import com.domingoslatorre.springcucumberselenitethymeleaf.cucumber.pages.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;

// https://stackoverflow.com/questions/60228404/no-tests-found-for-given-includes-when-running-gradle-tests-in-intellij-idea
public class SignupSteps {
    private SignUpPage signUpPage;

    @Given("^I am on sign up form$")
    public void IamOnSignUpForm() {
        signUpPage = open(SignUpPage.URL, SignUpPage.class);
        screenshot(SignUpPage.class.getSimpleName() + "before");
    }

    @When("^I define (.+) as name$")
    public void IEnterMyName(String name) {
        signUpPage.setName(name);
    }

    @When("^I enter my email (.+)")
    public void IEnterMyEmail(String email) {
        signUpPage.setEmail(email);
    }

    @And("^I enter a password (.+)$")
    public void IEnterMyPassword(String password) {
        signUpPage.setPassword(password);
    }

    @And("^I enter the password confirmation (.+)$")
    public void IEnterThePasswordConfirmation(String passwordConfirmation) {
        signUpPage.setPasswordConfirmation(passwordConfirmation);
    }

    @And("^I accept the terms of use$")
    public void IAcceptTheTermsOfUse() {
        signUpPage.acceptTermsOfUse();
        screenshot(SignUpPage.class.getSimpleName() + "after");
    }

    @And("^I send the form information$")
    public void ISendTheFormInformation() {
        signUpPage.submit();
    }

    @Then("^I should be redirected to the home page$")
    public void IShouldBeRedirectedToTheHomePage() {
        signUpPage.redirectToTheHomePage();
    }
}

