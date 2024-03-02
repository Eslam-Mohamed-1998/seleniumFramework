package Runner;

import Tests.TestesBase;
import io.cucumber.testng.CucumberOptions;

<<<<<<< HEAD
@CucumberOptions (features = "src/test/java/Features/PaymentRequestWithValidData"
		+ ".feature" , glue = {"Steps"} , 
=======
@CucumberOptions (features = "src/test/java/Features/userUpdateWarehouseData.feature" , glue = {"Steps"} , 
>>>>>>> 9932203caa1a09dccedf8bbcc7910da780927a20
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html"
    } )
public class TestRunner extends TestesBase{
	  
}
