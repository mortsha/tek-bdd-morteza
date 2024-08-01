package tek.bdd.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@SecurityTest", // tags of our scenario
        features = "classpath:features", // directory of our feature files
        glue = "tek.bdd.steps", // package of our steps
        dryRun = false, // make sure every step has their annotation on it.

        monochrome = true, // printable console
        snippets = CucumberOptions.SnippetType.CAMELCASE, // method reading for steps
        plugin = {
                // our plugins
        }
)


public class TestRunner {
}
