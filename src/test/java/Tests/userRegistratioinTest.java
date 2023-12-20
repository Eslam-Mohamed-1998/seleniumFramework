package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.homePage;
import Pages.loginPage;
import Pages.userRegistrationPage;

public class userRegistratioinTest extends TestesBase {
	homePage homeObject;
	userRegistrationPage userRegisterObject ;
	loginPage loginObject ;
	@Test (priority = 1 , alwaysRun = true)
	public void userCanRegistration () //throws InterruptedException 
	{
		homeObject = new homePage(driver);
		homeObject.openRegistrationPage();
		userRegisterObject = new userRegistrationPage(driver);
		userRegisterObject.userRegistration("Eslam", "Mohamed", "Eslam@Test100000000.com", "123456789Eslam");
		//Thread.sleep(2000);
		Assert.assertTrue(userRegisterObject.successMsg.getText().contains("Your registration completed"));
	}
	@Test (dependsOnMethods = {"userCanRegistration"})
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
