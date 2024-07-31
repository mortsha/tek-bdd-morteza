package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.utility.Utility;


public class HomePageSteps extends Utility {
    @Then("validate the top left corner TEKSCHOOL")
    public void validateTopLogo() {
        String title = getElementText(By.linkText("TEKSCHOOL"));
        System.out.println(title);
        Assert.assertEquals("TEKSCHOOL", title);
    }

    @Then("validate sign in button is Enabled")
    public void validateSignInButton(){
        boolean isSignInEnabled =  isEnabled(By.id("signinLink"));
        Assert.assertTrue(isSignInEnabled);
    }
}
