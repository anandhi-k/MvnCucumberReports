package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "@target//failed_scenarios.txt",
		glue = {"stepdefs"},
		monochrome=true
		)
public class RerunRunner {

}
