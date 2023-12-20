package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.homePage;
import Pages.logOutPage;
import Pages.loginPage;
import Pages.userRegistrationPage;
import testData.ExcelReader;

public class userRegistratioinTestUsingDDTAndPoiAndExcelReader extends TestesBase {
	homePage homeObject;
	userRegistrationPage userRegisterObject ;
	loginPage loginObject ;
	logOutPage logOutObject ;
	
	//Define And Prepare The Test data using Data Provider annotation
	
	@DataProvider (name = "testData")
	public static Object[][] userData() throws IOException
	{
		ExcelReader Er = new ExcelReader();
		return Er.excelReader();
	}
	
	@Test (priority = 1 , alwaysRun = true , dataProvider = "testData")
	public void userCanRegistration (String fName , String lName , String email , String pass) //throws InterruptedException 
	{
		homeObject = new homePage(driver);
		logOutObject = new logOutPage(driver);
		homeObject.openRegistrationPage();
		userRegisterObject = new userRegistrationPage(driver);
		userRegisterObject.userRegistration(fName, lName, email, pass);
		//Thread.sleep(2000);
		Assert.assertTrue(userRegisterObject.successMsg.getText().contains("Your registration completed"));
		//logOutObject.userCanLogOut();
		homeObject.openLoginPage();
		loginObject = new loginPage(driver);
		loginObject.userCanLogin(email, pass);
		Assert.assertTrue(loginObject.logoutBtn.getText().contains("Log out"));
		logOutObject.userCanLogOut();
	}
	@Test (dependsOnMethods = {"userCanRegistration"} , enabled = false)
	public void registeredUserCanLogin () //throws InterruptedException 
	{
		homeObject = new homePage(driver);
		homeObject.openLoginPage();
		loginObject = new loginPage(driver);
		loginObject.userCanLogin("Eslam@Test10000.com", "123456789Eslam");
		//Thread.sleep(2000);
		Assert.assertTrue(loginObject.logoutBtn.getText().contains("Log out"));
	}
}
