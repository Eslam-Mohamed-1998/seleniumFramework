package systemSetUp_inventoryConfiguration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Pages.pagesBase;

public class HomePage extends pagesBase{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy (css = "span.name")
	public WebElement userProfileMenu ;
	
	@FindBy (css = "a.nav-link")
	public WebElement logOutBtn ;
	
	@FindBy (css = "a.navbar-brand.d-flex.align-items-center")
	public WebElement branchName ;
	
	@FindBy(name = "InputSearch")
	WebElement screenName ;
	
	@FindBy (linkText = "Warehouses Data")
	WebElement searchTarget;
	
	public void searchForScreen (String ScreenName) 
	{
		sendTxtToInputTxt(screenName, ScreenName);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		clickBtn(searchTarget);
	}
}
