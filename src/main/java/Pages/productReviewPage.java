package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productReviewPage extends pagesBase{

	public productReviewPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (css = "input.review-title")
	WebElement reviewTitle;
	
	@FindBy (id  = "AddProductReview_ReviewText")
	WebElement reviewTxt;
	
	@FindBy (id  = "addproductrating_4")
	WebElement reviewRate;
	
	@FindBy (css  = "button.button-1.write-product-review-button")
	WebElement submitReviewBtn;
	
	@FindBy (css = "div.result")
	public WebElement successMesg ;
	
	public void addProductReview(String reviewTitleTxt , String reviewText) 
	{
		sendTxtToInputTxt(reviewTitle, reviewTitleTxt);
		sendTxtToInputTxt(reviewTxt, reviewText);
		clickBtn(reviewRate);
		clickBtn(submitReviewBtn);
	}
}
