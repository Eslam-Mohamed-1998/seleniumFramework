package Tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.checkOutPage;
import Pages.orderDetailsPage;
import Pages.searchPage;
import Pages.searchProductDetailsPage;
import Pages.shoppingCartPage;

public class checkOutProductAsGuestUserTest extends TestesBase{
	
	searchPage searchObject;
	searchProductDetailsPage searchProductDetailsObject;
	shoppingCartPage shoppingCartObject ;
	checkOutPage checkOutObject ;
	orderDetailsPage orderDetailsObject;
	
	public String searchTxt = "Asus";
	public String fName = "Eslam";
	public String LName = "Mohamed";
	public String email = "Eslam@Test12222222222.com";
	public String cityName = "Cairo";
	public String address1Details = "Helwan-15 May City - Building 3";
	public String postalCodeNum = "112011";
	public String phoneNum = "01016870180";
	
	//Search For Product 
	@Test (priority = 1)
	public void userCanSearchForProductUsingAutoSuggest() 
	{
		searchObject = new searchPage(driver);
		searchProductDetailsObject = new searchProductDetailsPage(driver);
		searchObject.searchForProductUsingAutoSuggest(searchTxt);
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Assert.assertTrue(searchProductDetailsObject.anotherConfirmedProduct().contains("Asus N551J"));
	}
	
	// add Product to Shopping Cart Page 
	@Test (priority = 2)
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
	@Test (priority = 3)
	public void openCheckOutProductPage() 
	{
		shoppingCartObject = new shoppingCartPage(driver);
		shoppingCartObject.openCheckOutPage();
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	}
	
	//click On CheckOut As Guest Button 
	@Test (priority = 4)
	public void clickOnCheckOutAsGuestButton() 
	{
		checkOutObject = new checkOutPage(driver);
		checkOutObject.checkOutOrderASGuest();
	}
	
	// check Out The Shopping Cart Products As Guest
	@Test (priority = 5)
	public void guestUserCancheckOutProduct() throws InterruptedException 
	{
		checkOutObject = new checkOutPage(driver);
		checkOutObject.checkOutProductAsGuest(fName, LName, email, 3 , cityName, address1Details, postalCodeNum, phoneNum);
		//Assert.assertTrue(checkOutObject.thankYouConfirmationOrderMessage.getText().contains("thankYouConfirmationOrderMessage"));
	}
	// open product Details Page 
	@Test (priority = 6)
	public void userOpenOrderDetilsPage() 
	{
		checkOutObject = new checkOutPage(driver);
		checkOutObject.openOrderDetilsPage();
	}
	
	// Download Order Details As PDF 
	@Test (priority = 7)
	public void userCanDownloadOrderDetailsAsPdf() 
	{
		orderDetailsObject = new orderDetailsPage(driver);
		orderDetailsObject.downloadOrderDetilsAsPdf();
	}
	
	// print Order Details 

	@Test (priority = 8)
	public void userCanPrintOrderDetails() 
	{
		orderDetailsObject = new orderDetailsPage(driver);
		orderDetailsObject.printOrderDetails();
	}
}
