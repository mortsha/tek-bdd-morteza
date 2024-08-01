@SecurityTest
Feature: Security test with valid and invalid credentials

  Background: validate title and navigate to sign in page
    Then validate the top left corner "TEKSCHOOL"
    When user click on sign in link
    Then validate user is in "sign in" page
  @positive
  Scenario: Navigate to sign in page with valid credentials and success login
    When user enter "mory123@gmail.com" and "Mory@123" and click on login
    Then user should be able to see "account" link

    @negative
    Scenario: Navigate to sign in page with invalid credentials and fail login
  Scenario: Navigate to sign in page with valid credentials and success login
    When user enter "wrongEmail@gmail.com" and "wrong pass" and click on login
    Then user should be able to see "wrong username or password" error message