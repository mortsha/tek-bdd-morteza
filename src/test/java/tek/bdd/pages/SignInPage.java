package tek.bdd.pages;

import org.openqa.selenium.By;

public class SignInPage {

    public static final By SIGN_IN_PAGE_SUBTITLE = By.className("login__subtitle");
    public static final By EMAIL_INPUT = By.id("email");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BTN = By.xpath("//button[text()='Login']");

    public static final By ERROR_MESSAGE = By.xpath("//div[contains(text(),'wrong username')]");
}
