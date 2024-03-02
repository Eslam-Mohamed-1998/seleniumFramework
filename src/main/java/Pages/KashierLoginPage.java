package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KashierLoginPage extends pagesBase {

	public KashierLoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (id = "email")
	WebElement emailInputField;
	
	@FindBy (id = "continue-btn")
	WebElement nextBtn ;

	@FindBy (id = "password")
	WebElement passwordInputField ;
	
	@FindBy (css  = "#continue-btn")
	WebElement loginBtn ; 
	
	public void insertEmailOrPhoneNo(String Email) 
	{
		sendTxtToInputTxt(emailInputField, Email);
		clickBtn(nextBtn);
		
	}
	
	public void login(String Pass) 
	{
		clearInputText(passwordInputField);
		sendTxtToInputTxt(passwordInputField, Pass);
		clickBtn(loginBtn);
	}
}
