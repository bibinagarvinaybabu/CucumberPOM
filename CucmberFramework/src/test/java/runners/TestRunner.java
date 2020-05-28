package runners;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/hotelBooking/hotalBooking.feature"},
		glue = {"stepDefinations"},
		monochrome = true,
		plugin = { "pretty", "html:target/Destination" }
		//tags={"@BackgroundTag"}
		)
public class TestRunner {
	
}