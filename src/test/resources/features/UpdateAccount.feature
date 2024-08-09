Feature: Navigate to Retail login with credentials update phone

  Background: Login to retail app with credentials
    When user click on "Sign in" link
    When user enter "mory123@gmail.com" and "Mory@123"
    When user click on "Login" button

  @UpdatePhoneAndName
  Scenario: Login with credential and update name and phone number
    When user click on "Account" link
    When user change the name "John" and phone number "2226664444" on account
    Then validate the data changed
    When user click on "Update" button
    Then validate Success toast message displayed

