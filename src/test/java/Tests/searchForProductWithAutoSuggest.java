package Tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.searchPage;
import Pages.searchProductDetailsPage;

public class searchForProductWithAutoSuggest extends TestesBase{
	String searchTxt = "Asus";
	searchPage searchObject;
	searchProductDetailsPage searchProductDetailsObject;
	@Test
	public void userCanSearchForProductUsingAutoSuggest() 
	{
		searchObject = new searchPage(driver);
		searchProductDetailsObject = new searchProductDetailsPage(driver);
		searchObject.searchForProductUsingAutoSuggest(searchTxt);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Assert.assertTrue(searchProductDetailsObject.anotherConfirmedProduct().contains("Asus N551J"));
	}
}
