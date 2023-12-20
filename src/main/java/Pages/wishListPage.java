package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class wishListPage extends pagesBase{

	public wishListPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (css = "button.remove-btn")
	WebElement removeFromWishLstBtn;
	
	@FindBy (css = "a.product-name")
	public WebElement productNameLink;
	
	@FindBy (id = "updatecart")
	WebElement updateWishlistBtn;
	
	@FindBy (css = "div.no-data")
	public WebElement wishListIsEmptyMessage ; 
	
	public void removeFromWighList() 
	{
		clickBtn(removeFromWishLstBtn);
	}
	
}
