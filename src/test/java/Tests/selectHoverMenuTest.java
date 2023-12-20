package Tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.homePage;

public class selectHoverMenuTest extends TestesBase{
	homePage homeObject;
	@Test
	public void UserCanSelectSubCategoryFromMainMenu() 
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		homeObject = new homePage(driver);
		homeObject.selectNoteBooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("notebooks"));
	}
}
