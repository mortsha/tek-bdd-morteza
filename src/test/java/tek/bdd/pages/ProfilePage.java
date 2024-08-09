package tek.bdd.pages;

import org.openqa.selenium.By;

public class ProfilePage {
    public static final By PROFILE_EMAIL = By.className("account__information-email");

    public static final By NAME_INPUT = By.id("nameInput");
    public static final By PHONE_NUMBER_INPUT = By.id("personalPhoneInput");

    public static final By SUCCESS_TOAST_MESSAGE = By.className("Toastify__toast-body");

}
