package utilities;
import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
//@CucumberOptions(
//        features= {"features/"},
//        glue="stepDefinitions",
//        monochrome=true,
//        tags= {"@RegressionTest"},
//        plugin= {"pretty","html:test-output"}
//)

@CucumberOptions(features = {
            "src/test/resources/features/LogIn.feature"
        },
        strict = false,
        plugin = {"pretty",
        "json:target/cucumber_json_reports/login.json",
        "html:target/login-html"},
        glue = {"StepDefinition"}
)

//@CucumberOptions(features = {"src/features"}, glue = "steps")
public class RunnerClass{

}