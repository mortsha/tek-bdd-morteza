package tek.bdd.pages;

import org.openqa.selenium.By;

import java.util.List;

public class SignUpPage {

    public static final By SIGN_UP_SUBTITLE = By.className("signup__subtitle");
    public static final By NAME_INPUT_SING_UP =By.id("nameInput");

    public static final By EMAIL_INPUT = By.id("emailInput");
    public static final By PASSWORD_INPUT = By.id("passwordInput");
    public static final By CONFIRM_PASS_INPUT = By.id("confirmPasswordInput");

    public static final By SIGN_UP_BUTTON = By.xpath("//button[text()='Sign Up']");

    public static final By SIGN_UP_ERROR_MESSAGE = By.className("error");

    public static final By NAME_ERROR = By.id("nameError");
    public static final By EMAIL_ERROR  = By.id("emailError");
    public static final By PASSWORD_ERROR = By.id("passwordError");
    public static final By CONFIRM_PASSWORD_ERROR = By.id("confirmPasswordError");
    public static final By ERROR_MESSAGE_LISTS = By.className("error");
}
