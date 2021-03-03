package utilities;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;


@RunWith(Cucumber.class)
@CucumberOptions(features = {
            "src/test/resources/features/"
        },
        strict = false,
        plugin = {"pretty",
        "json:target/cucumber_json_reports/login.json",
        "html:Test-output"},
        tags= {"@RegressionTest"},
        glue = {"StepDefinition"}
)

public class RunnerClass extends AbstractTestNGCucumberTests {
//        @Override
//        @DataProvider(parallel = true)
//        public Object[][] scenarios() {
//                return super.scenarios();
//        }
}