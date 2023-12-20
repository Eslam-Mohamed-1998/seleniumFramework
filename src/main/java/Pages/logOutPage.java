package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class logOutPage extends pagesBase{

	public logOutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (linkText = "Log out")
	WebElement logOutBtn ;
	
	public void userCanLogOut() 
	{
		clickBtn(logOutBtn);
	}
}
