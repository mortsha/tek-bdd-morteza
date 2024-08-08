package tek.bdd.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.base.BaseSetup;

import java.time.Duration;
import java.util.List;

public class Utility extends BaseSetup {

    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(15));
    }

    private WebElement waitToBeClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    private WebElement waitToBeVisible(By locator) {
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

    public boolean isElementEnabled(By locator) {
        return waitToBeVisible(locator).isEnabled();
    }

    public boolean isElementDisplayed(By locator) {
        return waitToBeVisible(locator).isDisplayed();
    }

    public byte[] takeScreenShot() {
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }

    public int getElementSize(By locator){
        return getDriver().findElements(locator).size();
    }

    public List<WebElement> getElements(By locator){
        return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
