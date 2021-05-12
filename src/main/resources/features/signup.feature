Feature: Costumer sign up

  Scenario: Costumer sign up successfully
    Given Jhon wants to have an account
    When He sends required information to get the account
    Then He should be told that the account was created

  Scenario: Costumer sign up failed
    Given Jhon wants to have an account
    When He sends required information to get the account
    Then He should be told that the account was not created