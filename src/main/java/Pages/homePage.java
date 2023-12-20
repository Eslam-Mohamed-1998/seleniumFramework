package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class homePage extends pagesBase {

	public homePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	
	@FindBy (linkText = "Register")
	WebElement registerLink;
	
	@FindBy (css = "a.ico-login")
	public WebElement loginLink;
	
	@FindBy (className = "ico-account")
	WebElement myAccoutLink;
	
	@FindBy (linkText = "Contact us")
	WebElement contactUsLink;
	
	@FindBy (id = "customerCurrency")
	WebElement currencyDropDownList ;
	
	@FindBy (linkText = "Computers ")
	WebElement computersMenu;
	
	@FindBy (linkText = "Notebooks ")
	WebElement noteBooksMenu;
	
	public void openRegistrationPage() 
	{
		clickBtn(registerLink);
	}
	public void openLoginPage() 
	{
		clickBtn(loginLink);
	}
	public void openMyAccountPage() 
	{
		clickBtn(myAccoutLink);
	}
	
	public void opencontactUsPage() 
	{
		scrollToBottom();
		clickBtn(contactUsLink);
	}
	
	public void changeCurrency() 
	{
		select = new Select(currencyDropDownList);
		select.selectByVisibleText("Euro");
	}
	
	public void selectNoteBooksMenu() 
	{
		action.moveToElement(computersMenu).moveToElement(noteBooksMenu).click().build().perform();
	}
}
