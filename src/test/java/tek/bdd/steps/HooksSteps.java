package tek.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import tek.bdd.utility.Utility;

public class HooksSteps extends Utility {

    @Before
    public void beforeEachScenario(){
        setupBrowser();
    }

    @After
    public void afterEachScenario(){
        quitBrowser();
    }

}
