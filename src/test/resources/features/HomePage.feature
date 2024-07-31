Feature: This feature is to Navigate to Home page of Retail app
@home
  Scenario: validate top left corner logo
    Given open browser and navigate to retail app
    Then validate the top left corner TEKSCHOOL
    Then close the browser