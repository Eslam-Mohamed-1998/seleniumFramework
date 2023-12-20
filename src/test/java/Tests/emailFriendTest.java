package Tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.emailFriendPage;
import Pages.homePage;
import Pages.logOutPage;
import Pages.loginPage;
import Pages.searchPage;
import Pages.searchProductDetailsPage;
import Pages.userRegistrationPage;

public class emailFriendTest extends TestesBase{
	homePage homeObject;
	userRegistrationPage userRegisterObject ;
	loginPage loginObject ;
	String searchTxt = "Asus";
	searchPage searchObject;
	searchProductDetailsPage searchProductDetailsObject;
	emailFriendPage emailFriendObject;
	logOutPage logOutobject;
	public String fName = "Eslam";
	public String lName = "Mohamed";
	public String eMail = "Eslam@TestNew2.com";
	public String passWord = "123456789Eslam";
	public String friendEmail = "MyFriend@Test.com";
	public String  myMessageForFriendEmail = "This Product Is Very Awesom , I suggest To Try It...";
	//1- User Registration & Login
	@Test (priority = 1 , alwaysRun = true)
	public void userCanRegistration () //throws InterruptedException 
	{
		homeObject = new homePage(driver);
		homeObject.openRegistrationPage();
		userRegisterObject = new userRegistrationPage(driver);
		userRegisterObject.userRegistration(fName, lName,eMail , passWord);
		//Thread.sleep(2000);
		Assert.assertTrue(userRegisterObject.successMsg.getText().contains("Your registration completed"));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	@Test (dependsOnMethods = {"userCanRegistration"} , priority = 2)
	public void registeredUserCanLogin () //throws InterruptedException 
	{
		homeObject = new homePage(driver);
		homeObject.openLoginPage();
		loginObject = new loginPage(driver);
		loginObject.userCanLogin(eMail, passWord);
		//Thread.sleep(2000);
		Assert.assertTrue(loginObject.logoutBtn.getText().contains("Log out"));
	}
	//2-Registered User Can Search Fore a Product 
	@Test (priority = 3)
	public void userCanSearchForProductUsingAutoSuggest() 
	{
		searchObject = new searchPage(driver);
		searchProductDetailsObject = new searchProductDetailsPage(driver);
		searchObject.searchForProductUsingAutoSuggest(searchTxt);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Assert.assertTrue(searchProductDetailsObject.anotherConfirmedProduct().contains("Asus N551J"));
	}
	//3- User Send Product For Email Friend 
	@Test (priority = 4)
	public void userCanSendProductMessageForFriendEmail() 
	{
		searchProductDetailsObject = new searchProductDetailsPage(driver);
		emailFriendObject = new emailFriendPage(driver);
		searchProductDetailsObject.openEmailProductToFriendPage();
		emailFriendObject.sendProductForEmailFriend(friendEmail, myMessageForFriendEmail);
		Assert.assertTrue(emailFriendObject.successSendEmailMessgae.getText().contains("Your message has been sent"));
	}
	//4-User Log Out 
	@Test (priority = 5)
	public void userLogOut() 
	{
		logOutobject = new logOutPage(driver);
		logOutobject.userCanLogOut();
	}
	
}
