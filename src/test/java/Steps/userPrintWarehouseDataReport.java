package Steps;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Tests.TestesBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import systemSetUp_inventoryConfiguration.HomePage;
import systemSetUp_inventoryConfiguration.WareousesDataPage;
import systemSetUp_inventoryConfiguration.loginPage;

public class userPrintWarehouseDataReport extends TestesBase{
	loginPage loginObject;
	HomePage HomeObject;
	WareousesDataPage WareousesDataObject ;
	public String UserName = "admin";
	public String Pass = "111";
	public String ScreenName = "Warehouses Data";
	@Given("The User at Sass Login Page")
	public void the_user_at_sass_login_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("http://192.168.50.107:31000/auth/login"));
	}

	@When("Enter The User name and The Password then click On Login button")
	public void enter_the_user_name_and_the_password_then_click_on_login_button() {
		loginObject = new loginPage(driver);
		loginObject.userLogin(UserName, Pass);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("Move To Saas Home Page")
	public void move_to_saas_home_page() {
		HomeObject = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(HomeObject.branchName));
	}

	@When("Enter The Screen Name and Search For it")
	public void enter_the_screen_name_and_search_for_it() {
		HomeObject.searchForScreen(ScreenName);
	}

	@When("The User Move To The Target Screen")
	public void the_user_move_to_the_target_screen() {
		WareousesDataObject = new WareousesDataPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(WareousesDataObject.allLink));
	}

	@When("Open Specific WareHouse Data Screen")
	public void open_specific_ware_house_data_screen() {
		WareousesDataObject = new WareousesDataPage(driver);
		WareousesDataObject.viewWarehouseScreen();
	}

	@When("Click On Print button and Generate The Report")
	public void click_on_print_button_and_generate_the_report() {
		WareousesDataObject.printReport();
	}

	@Then("The User Will Generate The Report")
	public void the_user_will_generate_the_report() {
		Assert.assertTrue(WareousesDataObject.ensurePrintDataRight.getText().contains("1 - Main Wrhs"));
		System.out.println("Done");
	}

}
