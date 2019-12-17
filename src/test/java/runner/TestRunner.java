package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import utility.CommonMethods;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature", 
				 glue = {"stepdefinition"},
				 plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
				 dryRun=false)
public class TestRunner {
	@AfterClass
	public static void setup() {
       CommonMethods.getReportConfigPath();
	 }
}
