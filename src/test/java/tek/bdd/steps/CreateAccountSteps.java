package tek.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.ProfilePage;
import tek.bdd.pages.SignInPage;
import tek.bdd.pages.SignUpPage;
import tek.bdd.utility.EmailGenerator;
import tek.bdd.utility.Utility;

import java.util.List;
import java.util.Map;

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


    @When("user enter new account info")
    public void userEnterNewAccountInfo(DataTable dataTable) {
        // convert Data table to Map
        Map<String,String> data = dataTable.asMap();
        String name = data.get("name");
        String email = data.get("email");
        String password = data.get("password");
        String confirmPass = data.get("confirmPassword");

        randomEmailGenerated = EmailGenerator.getEmail(name);
        String emailToUse = email.equalsIgnoreCase("random") ? randomEmailGenerated : email;
        sendText(SignUpPage.NAME_INPUT_SING_UP, name);
        sendText(SignUpPage.EMAIL_INPUT, emailToUse);
        sendText(SignUpPage.PASSWORD_INPUT, password);
        sendText(SignUpPage.CONFIRM_PASS_INPUT, confirmPass);
    }

    @When("user enter new account info using list data")
    public void userEnterNewAccountInfoUsingListData(io.cucumber.datatable.DataTable dataTable) {
       // convert Data table to List
        List<String> data = dataTable.asList();
        String name = data.get(0);
        String email = data.get(1);
        String password = data.get(2);
        String confirmPassword = data.get(3);

        randomEmailGenerated = EmailGenerator.getEmail(name);
        String emailToUse = email.equalsIgnoreCase("random") ? randomEmailGenerated : email;
        sendText(SignUpPage.NAME_INPUT_SING_UP, name);
        sendText(SignUpPage.EMAIL_INPUT, emailToUse);
        sendText(SignUpPage.PASSWORD_INPUT, password);
        sendText(SignUpPage.CONFIRM_PASS_INPUT, confirmPassword);
    }

    @When("user enter new account info using list of list data")
    public void userEnterNewAccountInfoUsingListOfListData(io.cucumber.datatable.DataTable dataTable) {
        // convert data table to list of list
       List<List<String>> data = dataTable.asLists();
       String name = data.get(0).get(0);
       String email = data.get(0).get(1);
       String password = data.get(0).get(2);

        randomEmailGenerated = EmailGenerator.getEmail(name);
        String emailToUse = email.equalsIgnoreCase("random") ? randomEmailGenerated : email;
        sendText(SignUpPage.NAME_INPUT_SING_UP, name);
        sendText(SignUpPage.EMAIL_INPUT, emailToUse);
        sendText(SignUpPage.PASSWORD_INPUT, password);
        sendText(SignUpPage.CONFIRM_PASS_INPUT, password);
    }


    @When("user enter new account info using list of map data")
    public void userEnterNewAccountInfoUsingListOfMapData(io.cucumber.datatable.DataTable dataTable) {
     // convert data table to list of map
        List<Map<String,String>> data = dataTable.asMaps();
        String email = data.get(0).get("email");
        String name = data.get(0).get("name");
        String password = data.get(0).get("password");

        randomEmailGenerated = EmailGenerator.getEmail(name);
        String emailToUse = email.equalsIgnoreCase("random") ? randomEmailGenerated : email;
        sendText(SignUpPage.NAME_INPUT_SING_UP, name);
        sendText(SignUpPage.EMAIL_INPUT, emailToUse);
        sendText(SignUpPage.PASSWORD_INPUT, password);
        sendText(SignUpPage.CONFIRM_PASS_INPUT, password);
    }
}
