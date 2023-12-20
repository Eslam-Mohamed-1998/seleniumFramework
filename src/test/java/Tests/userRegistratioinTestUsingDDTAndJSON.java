package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;

import org.testng.annotations.Test;

import Pages.homePage;
import Pages.logOutPage;
import Pages.loginPage;
import Pages.userRegistrationPage;

import testData.JsonDataReader;

public class userRegistratioinTestUsingDDTAndJSON extends TestesBase {
	homePage homeObject;
	userRegistrationPage userRegisterObject ;
	loginPage loginObject ;
	logOutPage logOutObject ;
	
	
	
	@Test (priority = 1 , alwaysRun = true )
	public void userCanRegistration () throws FileNotFoundException, IOException, ParseException //throws InterruptedException 
	{
		JsonDataReader jReader = new JsonDataReader();
		jReader.jsonDataReader();
		homeObject = new homePage(driver);
		logOutObject = new logOutPage(driver);
		homeObject.openRegistrationPage();
		userRegisterObject = new userRegistrationPage(driver);
		userRegisterObject.userRegistration (jReader.FirstName,jReader.LastName,jReader.Email,jReader.Pass);
		//Thread.sleep(2000);
		Assert.assertTrue(userRegisterObject.successMsg.getText().contains("Your registration completed"));
		//logOutObject.userCanLogOut();
		homeObject.openLoginPage();
		loginObject = new loginPage(driver);
		loginObject.userCanLogin(jReader.Email , jReader.Pass);
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
