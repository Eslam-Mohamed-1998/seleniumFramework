package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class comparePage extends pagesBase {

	public comparePage(WebDriver driver) {
		super(driver);
	}
	@FindBy (css = "a.clear-list")
	public WebElement clearCompareLstBtn ; 
	
	@FindBy (css = "table.compare-products-table")
	public WebElement compareProductsTable ;
	
	@FindBy (tagName = "tr")
	public List<WebElement> allRows;
	
	@FindBy (tagName = "td")
	public List<WebElement> allCols;
	
	@FindBy (css = "div.no-data")
	public WebElement noDataToCompareMessage;
	
	@FindBy (linkText = "Asus N551JK-XO076H Laptop")
	public WebElement firstProduct ;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement secondProduct;
	
	@FindBy (linkText = "product comparison")
	WebElement productComparisonLink;
	
	public void getProductsFromCompareList() 
	{
		//Get All Rows Size 
		System.out.println(allRows.size()+ "\t");
		for (WebElement row : allRows) 
		{
			//System.out.println(row.getText()+ "\t");
			for (WebElement col : allCols) 
			{
				System.out.println(col.getText() + "\t");
			}
		}
	}
	
	public void clearCompareProductList() 
	{
		clickBtn(clearCompareLstBtn);
	}
	public void openProductComprasionPage() 
	{
		clickBtn(productComparisonLink);
	}

}
