package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.utility.Utility;


public class HomePageSteps extends Utility {

    @Then("validate the top left corner {string}")
    public void validateTheTopLeftCorner(String expectedTitle) {
        String actualTitle = getElementText(By.className("top-nav__logo"));
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("validate sign in button is Enabled")
    public void validateSignInButton(){
        boolean isSignInEnabled =  isElementEnabled(By.id("signinLink"));
        Assert.assertTrue(isSignInEnabled);
    }
}
