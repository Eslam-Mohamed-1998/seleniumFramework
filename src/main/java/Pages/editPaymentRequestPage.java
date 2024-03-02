package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class editPaymentRequestPage extends pagesBase{

	public editPaymentRequestPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//*[@id=\"customerName\"]")
	WebElement updatedCusNameInputField ;
	
	@FindBy (xpath = "//*[@id=\"totalAmount\"]")
	WebElement updatedAmountInputField ;
	
	@FindBy (id = "editPaymentRequest")
	WebElement saveBtn ;
	
	@FindBy (xpath = "/html/body/app-root/div/k-toastr/div/div/div/p")
	public WebElement updateSuccessfullyAlret ;
	
	
	
	public void updateRequestData (String newCusName ,String newAmount ) 
	{
		clearInputText(updatedCusNameInputField);
		sendTxtToInputTxt(updatedCusNameInputField, newCusName);
		clearInputText(updatedAmountInputField);
		sendTxtToInputTxt(updatedAmountInputField, newAmount);
		clickBtn(saveBtn);
	}

}
