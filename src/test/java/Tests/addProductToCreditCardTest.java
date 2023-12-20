package Tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.searchPage;
import Pages.searchProductDetailsPage;
import Pages.shoppingCartPage;

public class addProductToCreditCardTest extends TestesBase {
	//Search For Product 
	public String searchTxt = "Asus";
	public String Quantity = "5";
	searchPage searchObject;
	searchProductDetailsPage searchProductDetailsObject;
	shoppingCartPage shoppingCartObject ;
	@Test (alwaysRun = true , priority = 1)
	public void userCanSearchForProductUsingAutoSuggest() 
	{
		searchObject = new searchPage(driver);
		searchProductDetailsObject = new searchProductDetailsPage(driver);
		searchObject.searchForProductUsingAutoSuggest(searchTxt);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Assert.assertTrue(searchProductDetailsObject.anotherConfirmedProduct().contains("Asus N551J"));
	}
	
	//Add Product To Credit cart &  Open credit Card Page 
	@Test (priority = 2)
	public void userCanAddProductToCreditCard() 
	{
		searchProductDetailsObject = new searchProductDetailsPage(driver);
		searchProductDetailsObject.opencreditCartPage();
		//Assert That The Name Is Appear Correct
		shoppingCartObject = new shoppingCartPage(driver);
		Assert.assertTrue(shoppingCartObject.totalCost.getText().contains("$1,500.00"));
		//Change Quantity And Assert It's Changed Correctlly
		shoppingCartObject.changeProductQuantity(Quantity);
		Assert.assertTrue(shoppingCartObject.totalCost.getText().contains("$7,500.00"));

	}
	
	// Remove Items From Credit Cart
	@Test (priority = 3)
	public void removeItemsFromCreditCardPage() 
	{
		shoppingCartObject = new shoppingCartPage(driver);
		shoppingCartObject.removeItemsFromCart();
		//Assert That The Empty Data Message Is appeared 
		Assert.assertTrue(shoppingCartObject.cartEmptyMessage.getText().contains("Your Shopping Cart is empty!"));
	}
}
