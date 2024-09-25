package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import tek.bdd.pages.HomePage;
import tek.bdd.utility.Utility;


public class HomePageSteps extends Utility {

    @Then("validate the top left corner {string}")
    public void validateTheTopLeftCorner(String expectedTitle) {
        String actualTitle = getElementText(HomePage.TITLE_LOGO);
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("validate sign in button is Enabled")
    public void validateSignInButton(){
        boolean isSignInEnabled =  isElementEnabled(HomePage.SIGN_IN_LINK);
        Assert.assertTrue(isSignInEnabled);
    }
}
