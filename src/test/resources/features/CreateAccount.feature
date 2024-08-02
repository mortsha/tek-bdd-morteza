Feature: Create new account in Retail app and validate

  Background: validate title and navigate to sign in page
    Then validate the top left corner "TEKSCHOOL"
    When user click on sign in link
    Then validate user is in "Sign in" page

@CreateNewAccount
  Scenario: Create new Account and validate the account
    When user click on Create New Account button
    Then validate the user is in "Sign Up" page
    When user enter "name" "Email" "Password" "Confirm Password" and click on Sign Up
    Then user should be able to see "account" link