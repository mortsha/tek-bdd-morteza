package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.ShoppingCartPage;
import tek.bdd.utility.Utility;

import java.util.List;

public class ProductAndOrderSteps extends Utility {

    @When("user enter {string} on search bar and click search")
    public void userEnterOnSearchBarAndClickSearch(String searchText) {
        sendText(HomePage.SEARCH_BAR_INPUT, searchText);
        clickOnElement(HomePage.SEARCH_BUTTON);
    }

    @Then("validate search result contains {string} for all products")
    public void validateSearchResultContainsForAllProducts(String expectedSearchKeyword) {
        List<WebElement> elements = getElements(HomePage.ALL_SEARCH_RESULTS_TITLE);
        Assert.assertFalse("Search result should not be empty ", elements.isEmpty());
        for (WebElement element : elements) {
            Assert.assertTrue(element.getText().toLowerCase().contains(expectedSearchKeyword.toLowerCase()));
        }

    }


    @When("user click on first item in search result")
    public void userClickOnFirstItemInSearchResult() {
        clickOnElement(HomePage.FIRST_SEARCHED_PRODUCT_TITLE);

    }


    @Then("verify {int} item in the cart list")
    public void verifyItemInTheCartList(int expectedCartSize) {
        List<WebElement> cartItems = getElements(ShoppingCartPage.CART_ITEM_LIST);
        Assert.assertEquals(cartItems.size(), expectedCartSize);
    }

    @When("user delete all items in cart")
    public void userDeleteAllItemsInCart() {
    getElements(ShoppingCartPage.ALL_ITEMS_DELETE)
            .forEach(each -> {
                clickOnElement(each);
            });
    }


    @Then("validate shopping cart is empty")
    public void validateShoppingCartIsEmpty() {
       boolean isDisplayed =  isElementDisplayed(ShoppingCartPage.CART_EMPTY_TITLE);
       Assert.assertTrue("Cart Empty title should be displayed",isDisplayed);
    }

}
