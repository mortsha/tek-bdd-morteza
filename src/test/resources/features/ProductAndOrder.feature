Feature: This feature is to validate everything related to product and order

  @UserStory7
  Scenario Outline: Validate search result for a searched keyword
    When user enter "<SearchKeyWord>" on search bar and click search
    Then validate search result contains "<SearchKeyWord>" for all products
    Examples:
      | SearchKeyWord |
      | TV            |
      | LG            |
      | Xbox          |
      | Sony          |

  @UserStory8
  Scenario: Add Product in card and delete
    When user click on "Sign in" link
    When user enter "mory123@gmail.com" on "Email" field
    When user enter "Mory@123" on "Password" field
    When user click on "Login" button
    Then user should be able to see "Account" link
    When user enter "TV" on search bar and click search
    Then validate search result contains "TV" for all products
    When user click on first item in search result
    When user click on "Add to Cart" button
    When user click on cart link
    Then verify 1 item in the cart list
    When user delete all items in cart
    Then validate shopping cart is empty

