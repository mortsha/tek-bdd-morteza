package tek.bdd.base;

import dev.failsafe.internal.util.Durations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseSetup {
    private static WebDriver driver;
    public WebDriver getDriver(){
        return driver;
    }
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }


    public void quitBrowser(){
        if(driver!=null){
            driver.quit();
        }
    }

}
