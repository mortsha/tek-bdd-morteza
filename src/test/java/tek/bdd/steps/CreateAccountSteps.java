package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.ProfilePage;
import tek.bdd.pages.SignInPage;
import tek.bdd.pages.SignUpPage;
import tek.bdd.utility.EmailGenerator;
import tek.bdd.utility.Utility;

public class CreateAccountSteps extends Utility {

    private static String randomEmailGenerated;
    @When("user click on Create New Account button")
    public void userClickOnCreateNewAccountButton() {
       clickOnElement(SignInPage.CREATE_NEW_ACCOUNT);
    }

    @When("user enter {string} {string} {string} {string} and click on Sign Up")
    public void userEnterAndClickOnSignUp(String name, String email, String password, String confirmPass) {
        randomEmailGenerated =EmailGenerator.getEmail(name);
        sendText(SignUpPage.NAME_INPUT_SING_UP,name);
        sendText(SignUpPage.EMAIL_INPUT, randomEmailGenerated);
        sendText(SignUpPage.PASSWORD_INPUT,password);
        sendText(SignUpPage.CONFIRM_PASS_INPUT,confirmPass);
        clickOnElement(SignUpPage.SIGN_UP_BUTTON);


    }

    @Then("validate email created")
    public void validateEmailCreated() throws InterruptedException {
        String actualProfileEmail = getElementText(ProfilePage.PROFILE_EMAIL);
        Assert.assertEquals(randomEmailGenerated,actualProfileEmail);
    }
}
