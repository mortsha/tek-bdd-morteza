package tek.bdd.base;

import dev.failsafe.internal.util.Durations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseSetup {
    private WebDriver driver;
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));



    }


    public WebDriver getDriver(){
        return driver;
    }

    public void quitBrowser(){
        if(driver!=null){
            driver.quit();
        }
    }

}
