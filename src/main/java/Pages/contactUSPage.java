package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class contactUSPage extends pagesBase{
	
	public contactUSPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (id="FullName")
	WebElement fullNameInpuTxt ;
	
	@FindBy (id="Email")
	WebElement EmailInputTxt ;
	
	@FindBy (id="Enquiry")
	WebElement enquiryMessageTxtArea ;
	
	@FindBy (name  ="send-email")
	WebElement submitBtn ;
	
	@FindBy(css = "div.result")
	public WebElement successMessage;
	
	public void contactUsSendMessage(String fullName , String Email , String enquiryMessage) 
	{
		sendTxtToInputTxt(fullNameInpuTxt,fullName );
		sendTxtToInputTxt(EmailInputTxt,Email );
		sendTxtToInputTxt(enquiryMessageTxtArea,enquiryMessage );
		clickBtn(submitBtn);
	}
	
}
