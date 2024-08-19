package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.ProfilePage;
import tek.bdd.utility.Utility;

public class CommonSteps extends Utility {

    @When("user click on {string} link")
    public void userClickOnLink(String linkVisibleText) {
        clickOnElement(By.linkText(linkVisibleText));
    }

    @When("user click on {string} button")
    public void userClickOnButton(String buttonVisibleText) throws InterruptedException {
        try {
            String xpath = "//button[text()='" + buttonVisibleText + "']";
            clickOnElement(By.xpath(xpath));
        } catch (TimeoutException exception) {
            String buttonXpath = "//*[text()='" + buttonVisibleText + "']/..";
            clickOnElement(By.xpath(buttonXpath));
            Thread.sleep(1000);
        }


    }

    @When("user enter {string} on {string} field")
    public void userEnterOnField(String value, String field) {
        String xpath = "//label[text()='" + field + "']//following-sibling::input";
        sendText(By.xpath(xpath), value);
    }

    @Then("validate Success toast message displayed")
    public void validateSuccessToastMessageDisplayed() {
        isElementDisplayed(ProfilePage.SUCCESS_TOAST_MESSAGE);
    }

    @When("wait for {} seconds")
    public void waitForSeconds(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


    @When("user click on cart link")
    public void userClickOnCartLink() {
        clickOnElement(HomePage.CART_LINK);
    }
}
