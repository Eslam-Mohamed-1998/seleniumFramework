package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KashierDashboardPage extends pagesBase{
	public KashierDashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#toggle") 
	WebElement switchModeBtn ;
	
	@FindBy (className = "mode")
	public WebElement modeLabel ;
	
	@FindBy (id = "paymentRequestsRoute")
	WebElement PaymentRequestLink ;
	
	public void switchMode () 
	{
		clickBtn(switchModeBtn);
	}
	
	public void openPaymentPage() 
	{
		clickBtn(PaymentRequestLink);
	}
}
