Feature: Create new account in Retail app and validate

  Background: validate title and navigate to sign in page
    Then validate the top left corner "TEKSCHOOL"
    When user click on sign in link
    Then validate user is in "Sign in" page

  @CreateNewAccount
  Scenario: Create new Account and validate the account
    When user click on Create New Account button
    Then validate user is in "Sign Up" page
    When user enter "Morteza" "mory.sh@gmail.com" "Anything@123" "Anything@123" and click on Sign Up
    Then validate email created