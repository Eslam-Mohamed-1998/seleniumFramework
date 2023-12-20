package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.searchPage;
import Pages.searchProductDetailsPage;

public class searchProductTest  extends TestesBase{
	String productName = "Apple MacBook Pro 13-inch";
	searchPage searchObject ;
	searchProductDetailsPage searchProductDetailsObject;
	@Test
	public void userCanSearchForProduct() 
	{
		searchObject = new searchPage(driver);
		searchProductDetailsObject = new searchProductDetailsPage(driver);
		searchObject.searchForProduct(productName);
		Assert.assertTrue(searchProductDetailsObject.confirmedProduct().contains(productName));
	}
}
