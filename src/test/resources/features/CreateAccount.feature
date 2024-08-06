@Regression
@CreateNewAccount
Feature: Create new account in Retail app and validate

  Background: validate title and navigate to sign in page
    When user click on "Sign in" link
    Then validate user is in "Sign in" page
    When user click on "Create New Account" link
    Then validate user is in "Sign Up" page

  Scenario: Create new Account and validate the account
    When user enter "Morteza" and "random" and "Anything@123" and "Anything@123"
    When user click on "Sign Up" button
    Then validate account successfully created

  Scenario: Create new account with existing email
    When user enter "Morteza" and "mory123@gmail.com" and "Anything@123" and "Anything@123"
    When user click on "Sign Up" button
    Then user should be able to see "this email is already exist, please use another email address" error message
