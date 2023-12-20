package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class orderDetailsPage extends pagesBase{

	public orderDetailsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (css = "a.button-2.print-order-button")
	WebElement printBtn;
	
	@FindBy (css = "a.button-2.pdf-invoice-button")
	WebElement downloadAsPdfBtn;
	
	public void printOrderDetails() 
	{
		clickBtn(printBtn);
	}
	
	public void downloadOrderDetilsAsPdf() 
	{
		clickBtn(downloadAsPdfBtn);
	}

}
