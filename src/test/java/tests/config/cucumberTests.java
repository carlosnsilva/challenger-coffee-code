package tests.config;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features"}, glue={"tests.stepsDefinitions"}, plugin = {"pretty", "html:src/test/resources/reports/executionResultReports.html"})
public class cucumberTests {
}
