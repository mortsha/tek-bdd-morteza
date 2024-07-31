Feature: This feature is to Navigate to Home page of Retail app
@homeLogo
  Scenario: validate top left corner logo
    Then validate the top left corner TEKSCHOOL

  @homeSignInBtn
  Scenario: validate top left corner with sign in button
    Then validate the top left corner TEKSCHOOL
    Then validate sign in button is Enabled
