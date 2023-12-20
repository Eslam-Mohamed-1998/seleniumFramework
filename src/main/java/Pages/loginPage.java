package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends pagesBase {

	public loginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (css = "input.email")
	WebElement emailInputTxt ;
	
	@FindBy (css = "input.password")
	WebElement passwordInputTxt ;
	
	@FindBy (css  = "button.button-1.login-button")
	WebElement loginBtn ;
	
	@FindBy (className = "ico-logout")
	public WebElement logoutBtn;
	
	public void userCanLogin(String email , String pass) 
	{
		sendTxtToInputTxt(emailInputTxt, email);
		sendTxtToInputTxt(passwordInputTxt, pass);
		clickBtn(loginBtn);
	}
	
}
