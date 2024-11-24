package com.digite.cloud.test.steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

//import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(
        features = {
//                "src/test/resources/features/Actions_Discussion_Post.feature",
                "src/test/resources/features/assignment.feature",
                "src/test/resources/features/assignment2.feature"
        }, // Path to the feature files
        glue = {"com.digite.cloud.test.steps"},  // Step definitions package
        plugin = {"pretty", "json:target/cucumber.json"} // Plugins for output formats
//        snippets = CAMELCASE // Optional: Use camelCase for method names
         // Add this line for parallel execution
)
public class CucumberChromeTestCombined extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();  // Run scenarios in parallel
    }
}