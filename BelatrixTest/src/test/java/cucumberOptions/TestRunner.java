package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue = "steps",
		plugin= {"pretty", "html:target/cucumber", "json:target/cucumber.json", "junit:target/BelatrixTestReport.xml"}		
)
public class TestRunner {

}
