package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.ProfilePage;
import tek.bdd.utility.DataGenerator;
import tek.bdd.utility.Utility;

public class UpdateAccountSteps extends Utility {

    private static String expectedName;
    private static String expectedPhoneNumber;

    @When("user change the name {string} and phone number {string} on account")
    public void userChangeTheNameAndPhoneNumberOnAccount(String name, String phoneNumber) {
        expectedName = name;
        expectedPhoneNumber = String.valueOf(DataGenerator.getRandomPhoneNumber());
      sendTextWithClearField(ProfilePage.NAME_INPUT,name);
      sendTextWithClearField(ProfilePage.PHONE_NUMBER_INPUT,expectedPhoneNumber);
    }


    @Then("validate the data changed")
    public void validateTheDataChanged() {
        String actualNameInput =  getElementValue(ProfilePage.NAME_INPUT);
        String actualPhoneNumber = getElementValue(ProfilePage.PHONE_NUMBER_INPUT);
        Assert.assertEquals("Actual and expected Name in profile should match",expectedName,actualNameInput);
        Assert.assertEquals("Actual and expected phone number in profile should match",expectedPhoneNumber,actualPhoneNumber);

    }
    @Then("validate Success toast message displayed")
    public void validateSuccessToastMessageDisplayed() {
        isElementDisplayed(ProfilePage.SUCCESS_TOAST_MESSAGE);
    }



}
