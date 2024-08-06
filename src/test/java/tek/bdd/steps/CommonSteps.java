package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tek.bdd.utility.Utility;

public class CommonSteps extends Utility {

    @When("user click on {string} link")
    public void userClickOnLink(String linkVisibleText) {
        clickOnElement(By.linkText(linkVisibleText));
    }
    @When("user click on {string} button")
    public void userClickOnButton(String buttonVisibleText) {
        String xpath = "//button[text()='"+ buttonVisibleText + "']";
        clickOnElement(By.xpath(xpath));
    }

}
