package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KashierPaymentPage extends pagesBase{

	public KashierPaymentPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (xpath = "//*[@id=\"element-to-print\"]/div[2]/div[4]/div/div/label/span")
	WebElement agreeTermsCheckBox ;
	
	@FindBy (id = "paymentRequestBtn")
	WebElement paynowBtn ;
	
	@FindBy (id = "pay-now-btn")
	WebElement confirmPaymentamountBtn ;
	
	
	@FindBy (xpath = "/html/body/app-root/app-main/div/app-iframe/payment-container/div[2]/div[1]/div[1]/div[2]/div/card-info/div/div[1]/button")
	public WebElement fillTestCardBtn ;
	
	@FindBy (id = "acssubmit")
	WebElement accSubmitBtn ;
	
	@FindBy (id = "closeModalBox")
	WebElement closePaymentRequestBox ;
	
	@FindBy (xpath = "/html/body/app-root/app-dashboard/div/app-view-payment-request/div/div/div[1]/div[1]/p")
	public WebElement PaymentRequestStatusLabel ;
	
	
	
	public void paynowConfirmation() 
	{
		clickBtn(agreeTermsCheckBox);
		clickBtn(paynowBtn);
		
	}
	
	
	public void setPaymentDetails() throws InterruptedException 
	{
		clickBtn(fillTestCardBtn);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement paymentCard = wait.until(ExpectedConditions.elementToBeClickable(confirmPaymentamountBtn));
		clickBtn(confirmPaymentamountBtn);
		Thread.sleep(Duration.ofSeconds(5));
	}
	
	public void accSubmit () 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement paymentCard = wait.until(ExpectedConditions.elementToBeClickable(accSubmitBtn));
		clickBtn(accSubmitBtn);
	}
	
	public void closePaymentRequest() 
	{
		clickBtn(closePaymentRequestBox);
	}
	
}
