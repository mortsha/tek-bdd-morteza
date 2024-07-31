package tek.bdd.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.base.BaseSetup;

import java.time.Duration;

public class SeleniumUtility extends BaseSetup {

    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(15));
    }
    public WebElement waitToBeClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitToBeVisible(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    public void clickOnElement(By locator) {
        waitToBeClickable(locator).click();
    }

    public void sendText(By locator, String text) {
        waitToBeVisible(locator).sendKeys(text);
    }

    public String getElementText(By locator) {
        return waitToBeVisible(locator).getText();
    }
}
