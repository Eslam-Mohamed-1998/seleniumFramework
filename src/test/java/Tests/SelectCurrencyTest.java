package Tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.homePage;
import Pages.searchPage;
import Pages.searchProductDetailsPage;

public class SelectCurrencyTest extends TestesBase{

	//Change Currency To Euro 
	homePage homeObject ;
	@Test (priority = 1)
	public void userCanChangeCurrency() 
	{
		homeObject = new homePage(driver);
		homeObject.changeCurrency();
	}
	
	//Search About Product To Get It's Currency 
	//Assert The Currency Is Changed
	String searchTxt = "Asus";
	searchPage searchObject;
	searchProductDetailsPage searchProductDetailsObject;
	@Test (priority = 2)
	public void userCanSearchForProductUsingAutoSuggest() 
	{
		searchObject = new searchPage(driver);
		searchProductDetailsObject = new searchProductDetailsPage(driver);
		searchObject.searchForProductUsingAutoSuggest(searchTxt);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Assert.assertTrue(searchProductDetailsObject.getProductPrice().contains("€1290.00"));
	}
	
	
}
