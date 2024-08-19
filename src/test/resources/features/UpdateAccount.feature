Feature: Navigate to Retail login with credentials update phone

  Background: Login to retail app with credentials
    When user click on "Sign in" link
    When user enter "mory123@gmail.com" on "Email" field
    When user enter "Mory@123" on "Password" field
    When user click on "Login" button
    When user click on "Account" link

  @UserStory5
  Scenario: Login with credential and update name and phone number
    Then validate user is in account page
    When user enter "John" on "Name" field
    When user enter "2226664444" on "Phone Number" field
    When user click on "Update" button
    Then validate Success toast message displayed
    Then validate account name is "John"
    When wait for 6 seconds
    When user enter "Steve" on "Name" field
    When user enter "1226664444" on "Phone Number" field
    When user click on "Update" button
    Then validate Success toast message displayed

  @UserStory6
  Scenario: Validate success password changes
    When user enter "Mory@123" on "Previous Password" field
    When user enter "Password@123" on "New Password" field
    When user enter "Password@123" on "Confirm Password" field
    When user click on "Change Password" button
    Then validate Success toast message displayed
    When wait for 6 seconds
    When user enter "Password@123" on "Previous Password" field
    When user enter "Mory@123" on "New Password" field
    When user enter "Mory@123" on "Confirm Password" field
    When user click on "Change Password" button
    Then validate Success toast message displayed
