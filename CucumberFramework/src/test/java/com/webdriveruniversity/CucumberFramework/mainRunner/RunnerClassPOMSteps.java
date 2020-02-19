package com.webdriveruniversity.CucumberFramework.mainRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions(
		monochrome = true,
		features = {"D://Selenium//CucumberFramework//src//test//java//com//webdriveruniversity//CucumberFramework//featureFiles//"},
		dryRun = false,
		tags = {"@pomSteps"},
		glue = {"com.webdriveruniversity.CucumberFramework.testSteps"},
		plugin = {"pretty","html:target/cucumber","json:cucumber.json","com.cucumber.listener.ExtentCucumberFormatter:target/report.html"}
		)
public class RunnerClassPOMSteps extends AbstractTestNGCucumberTests {
}
