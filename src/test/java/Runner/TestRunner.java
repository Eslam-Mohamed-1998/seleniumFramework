package Runner;

import Tests.TestesBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features = "src/test/java/Features/PaymentRequestWithValidData"
		+ ".feature" , glue = {"Steps"} , 
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html"
    } )
public class TestRunner extends TestesBase{
	  
}
