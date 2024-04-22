package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/features", 
plugin = {"pretty", "html:target/cucumber.html",
"json:target/cucumber.json"},
glue = { "com.ui.automation.suite.amazon.stepdefinitions" })

public class SuiteRunner extends AbstractTestNGCucumberTests {

}
