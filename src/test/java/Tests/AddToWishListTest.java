package Tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.searchPage;
import Pages.searchProductDetailsPage;
import Pages.wishListPage;

public class AddToWishListTest extends TestesBase {
	String searchTxt = "Asus";
	searchPage searchObject;
	searchProductDetailsPage searchProductDetailsObject;
	wishListPage wishListObject ;
	@Test (priority = 1)
	public void userCanSearchForProductUsingAutoSuggest() 
	{
		searchObject = new searchPage(driver);
		searchProductDetailsObject = new searchProductDetailsPage(driver);
		searchObject.searchForProductUsingAutoSuggest(searchTxt);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Assert.assertTrue(searchProductDetailsObject.anotherConfirmedProduct().contains("Asus N551J"));
	}
	@Test (priority = 2)
	public void userCanAddProductToWishList() 
	{
		searchProductDetailsObject = new searchProductDetailsPage(driver);
		wishListObject = new wishListPage(driver);
		searchProductDetailsObject.addToWishList();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		searchProductDetailsObject.openWishListPage();
		Assert.assertTrue(wishListObject.productNameLink.getText().contains("Asus N551JK-XO076H Laptop"));
	}
	@Test (priority = 3)
	public void userCanRemoveProductFromWishList() 
	{
		wishListObject = new wishListPage(driver);
		wishListObject.removeFromWighList();
		Assert.assertTrue(wishListObject.wishListIsEmptyMessage.getText().contains("empty"));
	}
	
}
