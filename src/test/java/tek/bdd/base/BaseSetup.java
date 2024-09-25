package tek.bdd.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import tek.bdd.browsers.BaseBrowser;
import tek.bdd.browsers.ChromeBrowser;
import tek.bdd.browsers.EdgeBrowser;
import tek.bdd.browsers.FirefoxBrowser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseSetup {
    private static WebDriver driver;
    private final Properties properties;
    private static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);

    public WebDriver getDriver() {
        return driver;
    }

    // find the full path to file
    // FileInputStream to read the file
    // Properties and load the FileInputStream to the properties

    public BaseSetup() {
        // System.getProperty("user.dir") return the location of your project

        try {
            String configFilePath = System.getProperty("user.dir") + "/src/test/resources/configs/dev-config.properties";
            LOGGER.info("Reading Config file " + configFilePath);
            File file = new File(configFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            LOGGER.error("Error reading config file, " + e);
            throw new RuntimeException("Something wrong with config file, " + e);
        }

    }

    public void setupBrowser() {
        // to open a Chrome browser in headless mode
        String browserType = properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        LOGGER.info("Running on browser {} and isHeadless {}", browserType, isHeadless);

        BaseBrowser browser;
        if (browserType.equalsIgnoreCase("chrome"))
            browser = new ChromeBrowser();
         else if (browserType.equalsIgnoreCase("firefox"))
            browser = new FirefoxBrowser();
         else if (browserType.equalsIgnoreCase("edge"))
            browser = new EdgeBrowser();
         else
            throw new RuntimeException("Wrong browser type");


        driver = browser.openBrowser(isHeadless);

        String url = properties.getProperty("ui.url");
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }


    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
