package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchPage extends pagesBase{

	public searchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "small-searchterms")
	WebElement searchInputTxt ;
	
	@FindBy (css = "button.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy (linkText = "Apple MacBook Pro 13-inch")
	WebElement searchProductResult ;
	
	@FindBy (id= "ui-id-1")
	List<WebElement> productList;
	
	public void searchForProduct (String productName) 
	{
		sendTxtToInputTxt(searchInputTxt, productName);
		clickBtn(searchBtn);
		clickBtn(searchProductResult);
	}
	
	public void searchForProductUsingAutoSuggest (String searchTxt) 
	{
		sendTxtToInputTxt(searchInputTxt, searchTxt);
		clickBtn(productList.get(0));
	}
}
