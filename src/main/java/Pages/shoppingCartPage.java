package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class shoppingCartPage extends pagesBase{

	public shoppingCartPage(WebDriver driver) {
		super(driver);
		}
	@FindBy (css = "button.remove-btn")
	WebElement removeBtn ;
	
	@FindBy (id = "updatecart")
	WebElement updateCardbtn ;
	
	@FindBy (css = "input.qty-input")
	WebElement quantityInputText;
	
	@FindBy (css = "span.product-subtotal")
	public WebElement totalCost;
	
	@FindBy (css = "a.product-name")
	WebElement productName;
	
	@FindBy (css = "div.no-data")
	public WebElement cartEmptyMessage ;
	
	@FindBy (id = "termsofservice")
	WebElement agreenmentChechBox;
	
	@FindBy (id = "checkout")
	WebElement checkOutBtn;
	
	public void changeProductQuantity (String quantity) 
	{
		clearInputText(quantityInputText);
		sendTxtToInputTxt(quantityInputText, quantity);
		clickBtn(updateCardbtn);
	} 
	
	public void removeItemsFromCart() 
	{
		clickBtn(removeBtn);
	}
	
	public void openCheckOutPage() 
	{
		clickBtn(agreenmentChechBox);
		clickBtn(checkOutBtn);
	}

}
