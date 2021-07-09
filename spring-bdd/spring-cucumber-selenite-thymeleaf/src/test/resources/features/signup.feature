@regression @signup
Feature: Sign Up
  As a visitor, I want to sign up

  Background:
    Given I am on sign up form

  Scenario: A visitor sign up with valid data
    When I define John as name
    And I enter my email email@email.com
    And I enter a password 123456
    And I enter the password confirmation 123456
    And I accept the terms of use
    And I send the form information
    Then I should be redirected to the home page
