package systemSetUp_inventoryConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Pages.pagesBase;

public class loginPage extends pagesBase{

	public loginPage(WebDriver driver) {
		super(driver);
	}
	// User Name Allocator 
	@FindBy (css = "input.form-control.ng-untouched.ng-pristine.ng-invalid")
	WebElement userName ;
	
	// Password Allocator 
	@FindBy (css = "input.form-control.ng-untouched.ng-pristine.ng-invalid")
	WebElement password ;
	
	// Login Button Allocator 
	@FindBy (css = "button.btn.btn-primary.btn-block")
	WebElement loginButton ;
	
	//Login Function 
	public void userLogin (String UserName , String pass) 
	{
		sendTxtToInputTxt(userName, UserName);
		sendTxtToInputTxt(password, pass);
		clickBtn(loginButton);
	}
}
