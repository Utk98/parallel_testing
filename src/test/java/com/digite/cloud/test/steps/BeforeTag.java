package test.java.com.digite.cloud.test.steps;

import com.digite.actions.drivercapabilities.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.util.Map;
import com.digite.actions.commands.Common;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;

public class BeforeTag extends Common {
    Common common;
    @Value("${aws.env}")
    String url;
    public BeforeTag(WebDriverFactory webDriverFactory) {
        super(webDriverFactory);
        common=new Common(webDriverFactory);
    }
    @Before
    public void before(Scenario scenario) throws InterruptedException {
        this.scenarioName = scenario.getName();
        this.scenario = scenario;
    }
    @Before
    public void initalizeWebdriver() throws Exception {
        common.navigate(url);
    }
    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()) {
            embedScreenshot(scenario);
        }
    }

}
