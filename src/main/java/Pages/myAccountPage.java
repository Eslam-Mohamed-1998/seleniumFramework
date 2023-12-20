package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends pagesBase {

	public myAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (linkText = "Change password")
	WebElement changePasswordLink;
	
	public void openChangePasswordPage() 
	{
		clickBtn(changePasswordLink);
	}
	
	@FindBy (id = "OldPassword")
	WebElement oldPasswordInputTxt;
	
	@FindBy (id = "NewPassword")
	WebElement newPasswordInputTxt;
	
	@FindBy (id = "ConfirmNewPassword")
	WebElement confirmNewPasswordPasswordInputTxt;
	
	@FindBy (css  = "button.button-1.change-password-button")
	WebElement changePasswordBtn;
	
	@FindBy (css = "p.content")
	public WebElement passwordChangedSuccessfullyMsg ;
	
	public void UserCanChangePassword(String oldPassword , String newPassword) 
	{
		sendTxtToInputTxt(oldPasswordInputTxt, oldPassword);
		sendTxtToInputTxt(newPasswordInputTxt, newPassword);
		sendTxtToInputTxt(confirmNewPasswordPasswordInputTxt, newPassword);
		clickBtn(changePasswordBtn);
	}
}
