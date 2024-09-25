package tek.bdd.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Regression", // tags of our scenario
        features = "classpath:features", // directory of our feature files
        glue = "tek.bdd.steps", // package of our steps
        dryRun = false, // make sure every step has their annotation on it.
        // dryRun = true is to validate that all steps in the feature files have corresponding step definitions in the code.

        monochrome = true, // printable console
        snippets = CucumberOptions.SnippetType.CAMELCASE, // method names as camel case
        plugin = {
                "pretty",
                "html:target/cucumber_report/index.html",
                "json:target/jsonReports/report.json"
                // our plugins
        }
)
public class TestRunner {
}
