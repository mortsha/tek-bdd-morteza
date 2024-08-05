package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.SignInPage;
import tek.bdd.pages.SignUpPage;
import tek.bdd.utility.Utility;

public class SecurityTestSteps extends Utility {

    @When("user click on sign in link")
    public void userClickOnSignInLink() {
        clickOnElement(HomePage.SIGN_IN_LINK);
    }

    @Then("validate user is in {string} page")
    public void validateUserIsInPage(String expectedString) {
        if(expectedString.equals("Sign in")){
            String actualSignInText = getElementText(SignInPage.SIGN_IN_PAGE_SUBTITLE);
            Assert.assertEquals(expectedString,actualSignInText);
        } else if(expectedString.equals("Sign Up")){
            String actualSignUpTitle = getElementText(SignUpPage.SIGN_UP_SUBTITLE);
            Assert.assertEquals(expectedString,actualSignUpTitle);
        }

    }

    @When("user enter {string} and {string} and click on login")
    public void userEnterAndAndClickOnLogin(String username, String password) {
        sendText(SignInPage.EMAIL_INPUT,username);
        sendText(SignInPage.PASSWORD_INPUT,password);
        clickOnElement(By.xpath("//button[text()='Login']"));

    }
    @Then("user should be able to see {string} link")
    public void userShouldBeAbleToSeeLink(String string) {
        Assert.assertTrue(isElementDisplayed(HomePage.ACCOUNT_LINK));
    }

    @Then("user should be able to see {string} error message")
    public void userShouldBeAbleToSeeErrorMessage(String expectedErrorMessage) {
            String actualErrorMessage = getElementText(SignInPage.ERROR_MESSAGE);
            Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }

}
