package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features={"@target/rerun.txt"},
		//features="./Features/Login.feature",
		//features="./Features/LoginDDTExcel.feature",
		features={"./Features/Registration.feature","./Features/Login.feature","./Features/LoginDDTExcel.feature"},
		glue={"stepDefinitions","hooks"},
		plugin= {
				"pretty", "html:reports/myreport.html", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/rerun.txt"
				},
		tags="@sanity and @regression",
		monochrome=true,
		dryRun=false,
		publish=true
		)

public class TestRunner {

}
