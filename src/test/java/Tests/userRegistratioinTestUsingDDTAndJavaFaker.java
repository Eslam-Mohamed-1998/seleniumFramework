package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Pages.homePage;
import Pages.logOutPage;
import Pages.loginPage;
import Pages.userRegistrationPage;
import testData.ExcelReader;

public class userRegistratioinTestUsingDDTAndJavaFaker extends TestesBase {
	homePage homeObject;
	userRegistrationPage userRegisterObject ;
	loginPage loginObject ;
	logOutPage logOutObject ;
	Faker fakeData = new Faker();
	public String fName = fakeData.name().firstName();
	public String lName = fakeData.name().lastName();
	public String email = fakeData.internet().emailAddress();
	public String pass = fakeData.number().digits(10).toString();
	@Test 
	public void userCanRegistration () //throws InterruptedException 
	{
		homeObject = new homePage(driver);
		logOutObject = new logOutPage(driver);
		homeObject.openRegistrationPage();
		userRegisterObject = new userRegistrationPage(driver);
		userRegisterObject.userRegistration(fName, lName, email, pass);
		System.out.println("The Values Of Fake Data Library Is: " + "  " + fName + " , " + lName + " , " + email + " , " + pass );
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
