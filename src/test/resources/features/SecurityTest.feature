@SecurityTest
Feature: Security test with valid and invalid credentials

  Background: validate title and navigate to sign in page
    Then validate the top left corner "TEKSCHOOL"
    When user click on sign in link
    Then validate user is in "Sign in" page
    Then validate user is in Sign in page

  @positive
  Scenario: Navigate to sign in page with valid credentials and success login
    When user enter "mory123@gmail.com" and "Mory@123" and click on login
    Then user should be able to see "account" link

  @negative
  Scenario Outline: Negative testing with credentials
    When user enter "<username>" and "<password>" and click on login
    Then user should be able to see "<errorMessage>" error message
    Examples:
      | username                | password  | errorMessage               |
      | wrongusername@gmail.com | Mory@123  | wrong username or password |
      | mory123@gmail.com       | wrongPass | wrong username or password |
