package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchProductDetailsPage extends pagesBase{

	public searchProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (css = "strong.current-item")
	WebElement confirmedProduct;
	
	@FindBy (css = "strong.current-item")
	WebElement anotherConfirmedProduct;
	
	@FindBy (css = "button.button-2.email-a-friend-button")
	WebElement emailFriendBtn ;
	
	@FindBy (id = "price-value-5")
	WebElement productPrice;
	
	@FindBy (linkText = "Add your review")
	WebElement addReviewLink ;
	
	
	@FindBy (id = "add-to-wishlist-button-5")
	WebElement addToWishLstBtn;
	
	@FindBy (linkText = "wishlist")
	WebElement wishListPageLink;
	
	@FindBy (css = "button.button-2.add-to-compare-list-button")
	WebElement addToCompareListBtn;
	
	@FindBy (id = "add-to-cart-button-5")
	WebElement addToCartBtn;
	
	@FindBy (linkText = "shopping cart")
	WebElement shoopingCartLinkPage ;
	
	public String confirmedProduct() 
	{
		String result = confirmedProduct.getText();
		return result;
	}
	
	public String anotherConfirmedProduct() 
	{
		String result = anotherConfirmedProduct.getText();
		return result;
	}
	
	public void openEmailProductToFriendPage() 
	{
		clickBtn(emailFriendBtn);
	}
	
	public String getProductPrice() 
	{
		String price = productPrice.getText();
		return price;
	}
	
	public void openReviewPage() 
	{
		clickBtn(addReviewLink);
	}
	
	public void addToWishList() 
	{
		clickBtn(addToWishLstBtn);
	}
	
	public void openWishListPage() 
	{
		clickBtn(wishListPageLink);
	}
	
	public void addProductToCompareList() 
	{
		clickBtn(addToCompareListBtn);
	}
	
	public void opencreditCartPage() 
	{
		clickBtn(addToCartBtn);
		clickBtn(shoopingCartLinkPage);
	}
}
