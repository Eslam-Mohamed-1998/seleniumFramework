package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class kashirPaymentRequestsPage extends pagesBase {

	public kashirPaymentRequestsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (id = "addPaymentRequest")
	WebElement addPaymentRequestBtn ;
	
	@FindBy (name = "customerName")
	WebElement customerNameInputField ;
	
	@FindBy (name = "totalAmount")
	WebElement amountInputfield ;
	
	@FindBy (id = "description")
	WebElement notesTextArea ;
	
	@FindBy (id = "sureModalBox")
	WebElement addBtn ; 
	
	@FindBy (id = "share")
	WebElement shareBtn ;
	
	@FindBy (xpath = "//*[@id=\"modal\"]/div[2]/div[2]/app-share-popup/form/div[1]/div[1]/a/k-image/img")
	WebElement redirectIcon ;
	
	@FindBy (className = "alert right success top")
	public WebElement alretMessage ;
	
	@FindBy (xpath = "//*[@id=\"modal\"]/div[2]/div[2]/div/div/div/form/div[1]/k-input/div[2]/span")
	public WebElement customerNameRequiredMessage ;
	
	@FindBy (xpath = "//*[@id=\"modal\"]/div[2]/div[2]/div/div/div/form/div[2]/div/k-input/div[2]/span")
	public WebElement amountRequiredMessage ;
	
	@FindBy (xpath = "/html/body/app-root/div/k-toastr/div/div/div/p")
	public WebElement totalAmountValidationMessage ;
	
	@FindBy (xpath = "//*[@id=\"modal\"]/div[2]/div[2]/div/div/div/form/div[2]/div/k-input/div[2]/span")
	public WebElement acceptedAmountDigitsMessage ;
	
	@FindBy (id = "editPaymentRequest")
	WebElement editPaymentRequestBtn ;
	
	@FindBy (id = "markAsPaid")
	WebElement markAsPaidBtn ;
	
	
	@FindBy (id = "sureModalBox")
	WebElement confirmMarkAsPaidBtn ;
	
	@FindBy (className = "success")
	public WebElement paidSuccessLabel ;
	
	@FindBy (id = "deletePaymentRequest")
	WebElement deletePaymentRequestBtn ;
	
	@FindBy (css = "button[value='Delete']")
	public WebElement confirmDeletePaymentRequestBtn ;
	
	@FindBy (xpath = "/html/body/app-root/div/k-toastr/div/div/div/p")
	public WebElement deltedSucessfulltMessage ;
	
	@FindBy (id = "currency")
	WebElement currencyParentList ;
	
	@FindBy (id = "currency-2-item")
	WebElement currencyWithUSDOption ;
	
	@FindBy (xpath = "/html/body/app-root/app-dashboard/div/app-view-payment-request/div/div/div[1]/div[1]/h3")
	public WebElement amountInUSDCurrencyLabel ;
	
	public void addPaymentRequest() 
	{
		clickBtn(addPaymentRequestBtn);
	}
	
	
	
	public void confirmPaymentRequestData (String CusName , String CusAmount , String PaymentNotes ) 
	{
		sendTxtToInputTxt(customerNameInputField, CusName);
		sendTxtToInputTxt(amountInputfield, CusAmount);
		sendTxtToInputTxt(notesTextArea, PaymentNotes);
		clickBtn(addBtn);
	}
	
	public void confirmPaymentRequestWithEmptyData(String CusName , String CusAmount , String PaymentNotes) 
	{
		sendTxtToInputTxt(customerNameInputField, CusName);
		clearInputText(customerNameInputField);
		sendTxtToInputTxt(amountInputfield, CusAmount);
		clearInputText(amountInputfield);
		sendTxtToInputTxt(notesTextArea, PaymentNotes);
		clickBtn(addBtn);
	} 
	
	public void openShareLink() 
	{
		clickBtn(shareBtn);
		clickBtn(redirectIcon);
	}
	
	public void editPaymentRequest() 
	{
		clickBtn(editPaymentRequestBtn);
	}
	
	public void markAsPaid() 
	{
		clickBtn(markAsPaidBtn);
	}
	
	public void confirmMarkAsPaid () 
	{
		action =new Actions(driver);
		action.doubleClick(confirmMarkAsPaidBtn);
		clickBtn(confirmMarkAsPaidBtn);
	}
	
	public void deletePaymentRequest() 
	{
		clickBtn(deletePaymentRequestBtn);
	}
	
	public void confirmdDeletePaymentRequest () 
	{
		action =new Actions(driver);
		action.doubleClick(confirmDeletePaymentRequestBtn);
		clickBtn(confirmDeletePaymentRequestBtn);
	}
	
	public void changeCurrency() 
	{
		clickBtn(currencyParentList);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement currenciesLst = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currency-2-item")));
		clickBtn(currencyWithUSDOption);
	}
}
