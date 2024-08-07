@Regression
@CreateNewAccountDT
Feature: Create new account in Retail app and validate

  Background: validate title and navigate to sign in page
    When user click on "Sign in" link
    Then validate user is in "Sign in" page
    When user click on "Create New Account" link
    Then validate user is in "Sign Up" page

  @UsingMap
  Scenario: Using a Map as Data Table
    When user enter new account info
      | name            | Morteza  |
      | email           | random   |
      | password        | Any@1234 |
      | confirmPassword | Any@1234 |
    When user click on "Sign Up" button
    Then validate account successfully created

  @UsingList
  Scenario: Using List as Data Table
    When user enter new account info using list data
      | Morteza  |
      | random   |
      | Any@1234 |
      | Any@1234 |
    When user click on "Sign Up" button
    Then validate account successfully created

  @UsingListOfList
  Scenario: Using List of List as Data Table
    When user enter new account info using list of list data
      | John | random | John@123 |
    When user click on "Sign Up" button
    Then validate account successfully created

  @UsingListOfMap
  Scenario: Using List of List as Data Table
    When user enter new account info using list of map data
      | John | random | John@123 |
    When user click on "Sign Up" button
    Then validate account successfully created

