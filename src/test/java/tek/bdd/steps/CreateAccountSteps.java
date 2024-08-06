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



    @When("user enter {string} and {string} and {string} and {string}")
    public void userEnterAndAndAnd(String name, String email, String password, String confirmPass) {
        randomEmailGenerated = EmailGenerator.getEmail(name);
        String emailToUse = email.equalsIgnoreCase("random") ? randomEmailGenerated : email;
        sendText(SignUpPage.NAME_INPUT_SING_UP, name);
        sendText(SignUpPage.EMAIL_INPUT, emailToUse);
        sendText(SignUpPage.PASSWORD_INPUT, password);
        sendText(SignUpPage.CONFIRM_PASS_INPUT, confirmPass);
    }

    @Then("validate account successfully created")
    public void validateAccountSuccessfullyCreated() {
        String actualProfileEmail = getElementText(ProfilePage.PROFILE_EMAIL);
        Assert.assertEquals("Email in account page should match with email used in create account steps", randomEmailGenerated, actualProfileEmail);
    }

    @Then("user should see {string} error message")
    public void userShouldSeeErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = getElementText(SignUpPage.SIGN_UP_ERROR_MESSAGE);
        Assert.assertEquals("Error message when user enter duplicate email should match with error message in sign up page", expectedErrorMessage, actualErrorMessage);
        System.out.println(actualErrorMessage);
    }

}
