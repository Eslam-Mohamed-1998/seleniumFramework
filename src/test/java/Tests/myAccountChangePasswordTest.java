package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.homePage;
import Pages.loginPage;
import Pages.myAccountPage;
import Pages.userRegistrationPage;

public class myAccountChangePasswordTest extends TestesBase{
	homePage homeObject;
	userRegistrationPage userRegisterObject ;
	loginPage loginObject ;
	myAccountPage myAccountObject;
	String firtName = "Eslam";
	String lastName = "Mohamed";
	String email = "Eslam@Test5000.com";
	String oldPassword = "123456789Eslam";
	String newPassword = "123456789";
	@Test (priority = 1 , alwaysRun = true)
	public void userCanRegistration () throws InterruptedException 
	{
		homeObject = new homePage(driver);
		homeObject.openRegistrationPage();
		userRegisterObject = new userRegistrationPage(driver);
		userRegisterObject.userRegistration(firtName,lastName , email , oldPassword);
		Thread.sleep(2000);
		Assert.assertTrue(userRegisterObject.successMsg.getText().contains("Your registration completed"));
	}
	@Test (dependsOnMethods = {"userCanRegistration"})
	public void registeredUserCanLogin () throws InterruptedException 
	{
		homeObject = new homePage(driver);
		homeObject.openLoginPage();
		loginObject = new loginPage(driver);
		loginObject.userCanLogin(email, oldPassword);
		Thread.sleep(2000);
		Assert.assertTrue(loginObject.logoutBtn.getText().contains("Log out"));
	}
	@Test (dependsOnMethods = {"registeredUserCanLogin"})
	public void openMyAccountPage () 
	{
		homeObject = new homePage(driver);
		homeObject.openMyAccountPage();
	}
	@Test (dependsOnMethods = {"openMyAccountPage"})
	public void openChangePasswordPage () 
	{
		myAccountObject = new myAccountPage(driver);
		myAccountObject.openChangePasswordPage();
	}
	@Test (dependsOnMethods = {"openChangePasswordPage"})
	public void userCanChangePassword () throws InterruptedException 
	{
		myAccountObject = new myAccountPage(driver);
		myAccountObject.UserCanChangePassword(oldPassword, newPassword);
		Thread.sleep(2000);
		Assert.assertTrue(myAccountObject.passwordChangedSuccessfullyMsg.getText().contains("Password was changed"));
	}
}
