package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class userRegistrationPage extends pagesBase {

	public userRegistrationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (id= "gender-male")
	WebElement maleGenderRdoBtn ;
	
	@FindBy (id= "FirstName")
	WebElement fNameTxtBox ;
	
	@FindBy (id= "LastName")
	WebElement lNameTxtBox ;
	
	@FindBy (id= "Email")
	WebElement eMailTxtBox ;
	
	@FindBy (id= "Password")
	WebElement passTxtBox ;
	
	@FindBy (id= "ConfirmPassword")
	WebElement confirmPassTxtBox ;
	
	@FindBy (id = "register-button")
	WebElement registerBtn ;
	@FindBy (className  = "result")
	public WebElement successMsg ;
	
	public void userRegistration (String firstName , String lastName , String EMail , String password) 
	{
		clickBtn(maleGenderRdoBtn);
		sendTxtToInputTxt(fNameTxtBox, firstName);
		sendTxtToInputTxt(lNameTxtBox, lastName);
		sendTxtToInputTxt(eMailTxtBox, EMail);
		sendTxtToInputTxt(passTxtBox, password);
		sendTxtToInputTxt(confirmPassTxtBox, password);
		clickBtn(registerBtn);
	}
}
