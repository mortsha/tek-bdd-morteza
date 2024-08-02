package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.SignInPage;
import tek.bdd.pages.SignUpPage;
import tek.bdd.utility.EmailGenerator;
import tek.bdd.utility.Utility;

public class CreateAccountSteps extends Utility {

    @When("user click on Create New Account button")
    public void userClickOnCreateNewAccountButton() {
       clickOnElement(SignInPage.CREATE_NEW_ACCOUNT);
    }


    @Then("validate the user is in {string} page")
    public void validateTheUserIsInPage(String expectedSignUpTitle) {
        String actualSignUpTitle = getElementText(SignUpPage.SIGN_UP_SUBTITLE);
        Assert.assertEquals(expectedSignUpTitle,actualSignUpTitle);

    }

    @When("user enter {string} {string} {string} {string} and click on Sign Up")
    public void userEnterAndClickOnSignUp(String name, String email, String password, String confirmPass) {
        String inputName = "Morteza";
        String randomEmail  =EmailGenerator.getEmail(inputName);
        sendText(SignUpPage.NAME_INPUT_SING_UP,inputName);
        sendText(SignUpPage.EMAIL_INPUT,randomEmail);
        sendText(SignUpPage.PASSWORD_INPUT,"Anything@123");
        sendText(SignUpPage.CONFIRM_PASS_INPUT,"Anything@123");
        clickOnElement(SignUpPage.SIGN_UP_BUTTON);
    }

}
