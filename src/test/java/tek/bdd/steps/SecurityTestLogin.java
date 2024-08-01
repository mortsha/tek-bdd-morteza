package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.utility.Utility;

public class SecurityTestLogin extends Utility {

    @When("user click on sign in link")
    public void userClickOnSignInLink() {
        clickOnElement(By.id("signinLink"));
    }

    @Then("validate user is in {string} page")
    public void validateUserIsInPage(String signInText) {
        Assert.assertTrue(isElementDisplayed(By.xpath("//h1[text()='Sign in']")));
    }

    @When("user enter {string} and {string} and click on login")
    public void userEnterAndAndClickOnLogin(String username, String password) {
        sendText(By.id("email"),username);
        sendText(By.id("password"),password);
        clickOnElement(By.xpath("//button[text()='Login']"));

    }
    @Then("user should be able to see {string} link")
    public void userShouldBeAbleToSeeLink(String string) {
        Assert.assertTrue(isElementDisplayed(By.linkText("Account")));
    }


    @Then("user should be able to see {string} error message")
    public void userShouldBeAbleToSeeErrorMessage(String expectedErrorMessage) {
            String actualErrorMessage = getElementText(By.xpath("//div[contains(text(),'wrong username')]"));
            Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }

}
