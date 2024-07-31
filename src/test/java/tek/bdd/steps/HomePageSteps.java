package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import tek.bdd.utility.Utility;

public class HomePageSteps extends Utility {
    @Given("open browser and navigate to retail app")
    public void openBrowserAndNavigate() {
        setupBrowser();
    }

    @Then("validate the top left corner TEKSCHOOL")
    public void validateTopLogo() {
        String title = getElementText(By.className("class=\"top-nav__logo"));
        System.out.println(title);
        System.out.println("Any thing");
    }

    @Then("close the browser")
    public void closeBrowser() {
        quitBrowser();
    }
}
