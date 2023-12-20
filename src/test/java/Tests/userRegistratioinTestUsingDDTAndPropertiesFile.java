package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.homePage;
import Pages.loginPage;
import Pages.userRegistrationPage;
import net.bytebuddy.implementation.FieldAccessor.FieldNameExtractor;
import testData.LoadProperties;

public class userRegistratioinTestUsingDDTAndPropertiesFile extends TestesBase {
	private static final String String = null;
	homePage homeObject;
	userRegistrationPage userRegisterObject ;
	loginPage loginObject ;
	String fName = LoadProperties.userData.getProperty("firstName");
	String lName = LoadProperties.userData.getProperty("lastName");
	String email = LoadProperties.userData.getProperty("Email");
	String Pass = LoadProperties.userData.getProperty("Password");
	@Test (priority = 1 , alwaysRun = true)
	public void userCanRegistration () //throws InterruptedException 
	{
		homeObject = new homePage(driver);
		homeObject.openRegistrationPage();
		userRegisterObject = new userRegistrationPage(driver);
		userRegisterObject.userRegistration(fName, lName, email, Pass);
		//Thread.sleep(2000);
		Assert.assertTrue(userRegisterObject.successMsg.getText().contains("Your registration completed"));
	}
	@Test (dependsOnMethods = {"userCanRegistration"})
	public void registeredUserCanLogin () //throws InterruptedException 
	{
		homeObject = new homePage(driver);
		homeObject.openLoginPage();
		loginObject = new loginPage(driver);
		loginObject.userCanLogin(email, Pass);
		//Thread.sleep(2000);
		Assert.assertTrue(loginObject.logoutBtn.getText().contains("Log out"));
	}
}
