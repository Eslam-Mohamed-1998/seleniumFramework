package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class pagesBase {
	protected WebDriver driver ;
	public JavascriptExecutor jse;
	public Select select;
	public Actions action;
	public Alert alert ;
	public  pagesBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	protected static void clickBtn(WebElement button) {
		button.click();
	}
	protected static void sendTxtToInputTxt(WebElement inputField , String value) 
	{
		inputField.sendKeys(value);
	}
	public void scrollToBottom() 
	{
		jse.executeScript("scrollBy(0,2500)");
	}
	public void clearInputText(WebElement elment) 
	{
		elment.clear();
	}
}
