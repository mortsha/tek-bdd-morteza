package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.ProfilePage;
import tek.bdd.utility.DataGenerator;
import tek.bdd.utility.Utility;

public class UpdateAccountSteps extends Utility {

    @Then("validate user is in account page")
    public void validateUserIsInAccountPage() {
        String actualProfileText = getElementText(ProfilePage.PROFILE_TITLE);
        Assert.assertEquals("Account page should contains Your Profile Text", "Your Profile", actualProfileText);
    }

    @Then("validate account name is {string}")
    public void validateAccountNameIs(String expectedProfileName) {
        String actualProfileName = getElementText(ProfilePage.PROFILE_ACCOUNT_NAME);
        Assert.assertEquals("Account Profile should Match", actualProfileName, expectedProfileName);
    }

}
