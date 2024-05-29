package cucumber.Options;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/feature"},
        glue = {"stepDefinitions"},
        dryRun = false,
        plugin = {"json:target/jsonReports/cucumber-report.json"}
)
public class TestRunner {


}
