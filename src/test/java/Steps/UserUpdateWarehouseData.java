package Steps;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import Tests.TestesBase;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import systemSetUp_inventoryConfiguration.HomePage;
import systemSetUp_inventoryConfiguration.WareousesDataPage;
import systemSetUp_inventoryConfiguration.loginPage;

public class UserUpdateWarehouseData extends TestesBase {
	loginPage loginObject;
	HomePage HomeObject;
	WareousesDataPage WareousesDataObject ;
	public String UserName = "admin";
	public String Pass = "111";
	public String ScreenName = "Warehouses Data";


	/*
	 * @ParameterType("SUCCESS|FAILURE|SKIP") public ITestResult testResult(String
	 * result) { // Convert the string to an ITestResult constant switch
	 * (result.toUpperCase()) { case "SUCCESS": return ITestResult.SUCCESS; case
	 * "FAILURE": return ITestResult.FAILURE; case "SKIP": return ITestResult.SKIP;
	 * default: throw new IllegalArgumentException("Invalid test result: " +
	 * result); } }
	 */
	
	public int i = 0;

	@Given("The User at SAAS Login Page")
	public void the_user_at_saas_login_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("http://192.168.50.107:31000/auth/login"));
	}

	@When("Enter The User Name and The Password then click On Login button")
	public void enter_the_user_name_and_the_password_then_click_on_login_button() {
		loginObject = new loginPage(driver);
		loginObject.userLogin(UserName, Pass);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("Move To SAAS Home Page")
	public void move_to_saas_home_page() {
		HomeObject = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(HomeObject.branchName));
	}

	@When("Enter The  Target Screen Name and Search For it")
	public void enter_the_target_screen_name_and_search_for_it() {
		HomeObject.searchForScreen(ScreenName);
	}

	@When("The User Move To The Screen")
	public void the_user_move_to_the_screen() {
		WareousesDataObject = new WareousesDataPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(WareousesDataObject.allLink));
	}

	@When("Open Specific WareHouse Data Update Screen")
	public void open_specific_ware_house_data_update_screen() {
		WareousesDataObject = new WareousesDataPage(driver);
		WareousesDataObject.openWarehouseUpdateScreen();
	}

	@When("Update The {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string} and Save The New Data")
	public void update_the_and_save_the_new_data(String WhName, String whAddress, String OperationUnit, String employee, String Location, String Remarks, String fDate, String tDate, String costCenter, String subLedger2) throws AWTException {
		WareousesDataObject.updateWarehouseData(WhName, whAddress, OperationUnit, employee, Location, Remarks, fDate, tDate, costCenter, subLedger2);
		i ++ ;
	}


	@Then("Check That The Warehouse Data Update Is Completed Depend On The Test Condation")
	public void check_that_the_warehouse_data_update_is_completed_depend_on_the_test_condation() {
		switch (i) {
        case 0 : 
           Assert.assertTrue(WareousesDataObject.whName.getText().contains("NewAutomationWH"));
        case 1:
           Assert.assertTrue(WareousesDataObject.whName.getText().contains("NewAutomationWH"));
        default:
            System.out.println("Out Of Assertions Collection ");
    }
		System.out.println("success");
		
	}

}
