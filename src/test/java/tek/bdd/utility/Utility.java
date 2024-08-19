package tek.bdd.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger LOGGER = LogManager.getLogger(Utility.class);

    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(15));
    }

    private WebElement waitToBeClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }
    private WebElement waitToBeClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    private WebElement waitToBeVisible(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public void clickOnElement(By locator) {
        waitToBeClickable(locator).click();
        LOGGER.info("Clicking on Element {} ", locator);
    }
    public void clickOnElement(WebElement element) {
        waitToBeClickable(element).click();
        LOGGER.info("Clicking on Element {} ", element);
    }


    public void sendText(By locator, String text) {
        LOGGER.info("Sending text {} to locator {} ", text, locator);
        WebElement element = waitToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }


    public String getElementText(By locator) {
        LOGGER.info("Getting the text of Element {} ", locator);
        return waitToBeVisible(locator).getText();
    }

    public boolean isElementEnabled(By locator) {
        LOGGER.info("Element Enabled: {} ", locator);
        return waitToBeVisible(locator).isEnabled();
    }

    public boolean isElementDisplayed(By locator) {
        LOGGER.info("Element Displayed: {} ", locator);
        return waitToBeVisible(locator).isDisplayed();
    }

    public byte[] takeScreenShot() {
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }

    public int getElementSize(By locator) {
        return getDriver().findElements(locator).size();
    }

    public List<WebElement> getElements(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }


    public String getElementValue(By locator) {
        return waitToBeVisible(locator).getAttribute("value");
    }
}
