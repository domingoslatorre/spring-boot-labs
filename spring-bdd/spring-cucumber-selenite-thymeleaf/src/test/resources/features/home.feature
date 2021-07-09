@regression @home
Feature: Home Page
  As a visitor, I want to see home page links

  Background:
    Given I am on home page

  Scenario: A visitor enters the home page
    Then I should see the sign up link
