package Pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkOutPage extends pagesBase{

	public checkOutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (xpath = "//*[@id=\"BillingNewAddress_CountryId\"]")
	WebElement countrySelection;

	@FindBy (id = "BillingNewAddress_City")
	WebElement cityInputText;

	@FindBy(id = "BillingNewAddress_Address1")
	WebElement address1InputText;

	@FindBy (id = "BillingNewAddress_ZipPostalCode")
	WebElement postalCodeInputText;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneNumberInputText;

	@FindBy (css = "button.button-1.new-address-next-step-button")
	WebElement billingAddressContinueBtn;

	@FindBy (id = "BillingNewAddress_FirstName")
	WebElement firstNameInputText ;

	@FindBy (id = "BillingNewAddress_LastName")
	WebElement lastNameInputText;

	@FindBy (id = "BillingNewAddress_Email")
	WebElement emailInputText;
	
	@FindBy (css = "button.button-1.checkout-as-guest-button")
	WebElement checkoutAsGuestBtn;

	@FindBy (css = "button.button-1.shipping-method-next-step-button")
	WebElement shippingMethodContinueBtn;

	@FindBy (css = "button.button-1.payment-method-next-step-button")
	WebElement paymentMethodContinueBtn;

	@FindBy (css = "button.button-1.payment-info-next-step-button")
	WebElement paymentInfoContinueBtn;

	@FindBy (css = "button.button-1.confirm-order-next-step-button")
	WebElement confirmOrderBtn;

	@FindBy (xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong")
	public WebElement thankYouConfirmationOrderMessage;

	@FindBy (css = "button.button-1.order-completed-continue-button")
	WebElement completeOrderContinueBtn;

	@FindBy (linkText = "Click here for order details.")
	WebElement orderDetailsLink ;

	@FindBy (id = "shippingoption_1")
	WebElement shippingMethoD ;

	public void checkOutProductAsRegisterUser (int counteryIndex , String City , String Address1 , String postalCode , String phoneNumber) throws InterruptedException 
	{
		select = new Select(countrySelection);
		select.selectByIndex(counteryIndex);
		sendTxtToInputTxt(cityInputText, City);
		sendTxtToInputTxt(address1InputText, Address1);
		sendTxtToInputTxt(postalCodeInputText, postalCode);
		sendTxtToInputTxt(phoneNumberInputText, phoneNumber);
		clickBtn(billingAddressContinueBtn);
		//Thread.sleep(10);
		//That's An Dismiss To The Alert 
		//alert = driver.switchTo().alert();
		//alert.dismiss();
		//jse.executeScript("arguments[0].click();", shippingMethodContinueBtn);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(shippingMethodContinueBtn));
		//clickBtn(shippingMethoD);
		clickBtn(shippingMethodContinueBtn);
		Thread.sleep(2);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		clickBtn(paymentMethodContinueBtn);
		Thread.sleep(2);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		clickBtn(paymentInfoContinueBtn);
		Thread.sleep(2);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		clickBtn(confirmOrderBtn);
	}
	
	
	public void checkOutProductAsGuest (String fName , String LName , String Email , int counteryIndex , String City , String Address1 , String postalCode , String phoneNumber) throws InterruptedException 
	{
		sendTxtToInputTxt(firstNameInputText, fName);
		sendTxtToInputTxt(lastNameInputText, LName);
		sendTxtToInputTxt(emailInputText, Email);
		select = new Select(countrySelection);
		select.selectByIndex(counteryIndex);
		sendTxtToInputTxt(cityInputText, City);
		sendTxtToInputTxt(address1InputText, Address1);
		sendTxtToInputTxt(postalCodeInputText, postalCode);
		sendTxtToInputTxt(phoneNumberInputText, phoneNumber);
		clickBtn(billingAddressContinueBtn);
		//Thread.sleep(10);
		//That's An Dismiss To The Alert 
		//alert = driver.switchTo().alert();
		//alert.dismiss();
		//jse.executeScript("arguments[0].click();", shippingMethodContinueBtn);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(shippingMethodContinueBtn));
		//clickBtn(shippingMethoD);
		clickBtn(shippingMethodContinueBtn);
		Thread.sleep(2);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		clickBtn(paymentMethodContinueBtn);
		Thread.sleep(2);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		clickBtn(paymentInfoContinueBtn);
		Thread.sleep(2);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		clickBtn(confirmOrderBtn);
	}

	public void openOrderDetilsPage() 
	{
		clickBtn(orderDetailsLink);
	}
	
	public void checkOutOrderASGuest() 
	{
		clickBtn(checkoutAsGuestBtn);
	}
}
