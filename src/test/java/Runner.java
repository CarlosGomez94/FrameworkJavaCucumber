package com.cucumber.test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//features//",
		glue="stepDefinitions",
		monochrome=true,
		tags= {"@RegressionTest"},
		plugin= {"pretty","html:test-output"}
		)

//@CucumberOptions(features = {"src/features"}, glue = "steps")
public class Runner extends AbstractTestNGCucumberTests{

}