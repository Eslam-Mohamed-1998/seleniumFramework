package Tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.comparePage;
import Pages.searchPage;
import Pages.searchProductDetailsPage;

public class addProductsToCompareTest extends TestesBase{
	searchPage searchobject ;
	searchProductDetailsPage searchProductDetailsobject ;
	comparePage compareObject ;
	public String firstProductName = "Asus";
	public String secondProductName = "Apple";

	@Test (priority = 1)
	public void userCanAddProductsToCompareList () throws InterruptedException 
	{
		//Search For Products 
		searchobject = new searchPage(driver);
		searchProductDetailsobject = new searchProductDetailsPage(driver);
		compareObject = new comparePage(driver);
		searchobject.searchForProductUsingAutoSuggest(firstProductName);;
		searchProductDetailsobject.addProductToCompareList();
		//Assert.assertTrue(firstProductName.contains("Asus N551JK-XO076H Laptop"));
		searchobject.searchForProductUsingAutoSuggest(secondProductName);;
		searchProductDetailsobject.addProductToCompareList();
		//Open CompareProducts Screen
		compareObject.openProductComprasionPage();
		Assert.assertTrue(compareObject.firstProduct.isDisplayed());
		Assert.assertTrue(compareObject.secondProduct.isDisplayed());
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		compareObject.getProductsFromCompareList();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//Assert.assertTrue(secondProductName.contains("Apple MacBook Pro 13-inch"));
	}
	@Test (priority = 2)
	public void userCanClearCompareProductsForList() 
	{
		compareObject = new comparePage(driver);
		compareObject.clearCompareProductList();
		Assert.assertTrue(compareObject.noDataToCompareMessage.getText().contains("You have no items to compare"));
	}
}
