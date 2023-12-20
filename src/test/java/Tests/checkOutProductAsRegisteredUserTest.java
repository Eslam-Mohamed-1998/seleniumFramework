package Tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.checkOutPage;
import Pages.homePage;
import Pages.loginPage;
import Pages.orderDetailsPage;
import Pages.searchPage;
import Pages.searchProductDetailsPage;
import Pages.shoppingCartPage;
import Pages.userRegistrationPage;

public class checkOutProductAsRegisteredUserTest extends TestesBase{
	//Register As New User 
	homePage homeObject;
	userRegistrationPage userRegisterObject ;
	loginPage loginObject ;
	searchPage searchObject;
	searchProductDetailsPage searchProductDetailsObject;
	shoppingCartPage shoppingCartObject ;
	checkOutPage checkOutObject ;
	orderDetailsPage orderDetailsObject;
	public String searchTxt = "Asus";
	public String fName = "Eslam";
	public String LName = "Mohamed";
	public String email = "Eslam@Test12222222222.com";
	public String pass = "123456789Eslam";
	public String cityName = "Cairo";
	public String address1Details = "Helwan-15 May City - Building 3";
	public String postalCodeNum = "112011";
	public String phoneNum = "01016870180";
	@Test (priority = 1 , alwaysRun = true)
	public void userCanRegistration () //throws InterruptedException 
	{
		homeObject = new homePage(driver);
		homeObject.openRegistrationPage();
		userRegisterObject = new userRegistrationPage(driver);
		userRegisterObject.userRegistration(fName, LName, email, pass);
		//Thread.sleep(2000);
		Assert.assertTrue(userRegisterObject.successMsg.getText().contains("Your registration completed"));
	}
	@Test (dependsOnMethods = {"userCanRegistration"} , priority = 2)
	public void registeredUserCanLogin () //throws InterruptedException 
	{
		homeObject = new homePage(driver);
		homeObject.openLoginPage();
		loginObject = new loginPage(driver);
		loginObject.userCanLogin(email, pass);
		//Thread.sleep(2000);
		Assert.assertTrue(loginObject.logoutBtn.getText().contains("Log out"));
	}
	
	//Search For Product 
	@Test (priority = 3)
	public void userCanSearchForProductUsingAutoSuggest() 
	{
		searchObject = new searchPage(driver);
		searchProductDetailsObject = new searchProductDetailsPage(driver);
		searchObject.searchForProductUsingAutoSuggest(searchTxt);
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Assert.assertTrue(searchProductDetailsObject.anotherConfirmedProduct().contains("Asus N551J"));
	}
	
	// add Product to Shopping Cart Page 
	@Test (priority = 4)
	public void userCanAddProductToCreditCard() 
	{
		searchProductDetailsObject = new searchProductDetailsPage(driver);
		searchProductDetailsObject.opencreditCartPage();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//Assert That The Name Is Appear Correct
		//shoppingCartObject = new shoppingCartPage(driver);
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//Assert.assertTrue(shoppingCartObject.totalCost.getText().contains("$1,500.00"));
	}
	
	//Open checkOut Product Page 
	@Test (priority = 5)
	public void openCheckOutProductPage() 
	{
		shoppingCartObject = new shoppingCartPage(driver);
		shoppingCartObject.openCheckOutPage();
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	}
	
	// check Out The Shopping Cart Products 
	@Test (priority = 6)
	public void RegisteredUserCancheckOutProduct() throws InterruptedException 
	{
		checkOutObject = new checkOutPage(driver);
		checkOutObject.checkOutProductAsRegisterUser(5 , cityName , address1Details , postalCodeNum , phoneNum );
		//Assert.assertTrue(checkOutObject.thankYouConfirmationOrderMessage.getText().contains("thankYouConfirmationOrderMessage"));
	}
	// open product Details Page 
	@Test (priority = 7)
	public void userOpenOrderDetilsPage() 
	{
		checkOutObject = new checkOutPage(driver);
		checkOutObject.openOrderDetilsPage();
	}
	
	// Download Order Details As PDF 
	@Test (priority = 8)
	public void userCanDownloadOrderDetailsAsPdf() 
	{
		orderDetailsObject = new orderDetailsPage(driver);
		orderDetailsObject.downloadOrderDetilsAsPdf();
	}
	
	// print Order Details 

	@Test (priority = 9)
	public void userCanPrintOrderDetails() 
	{
		orderDetailsObject = new orderDetailsPage(driver);
		orderDetailsObject.printOrderDetails();
	}
}
