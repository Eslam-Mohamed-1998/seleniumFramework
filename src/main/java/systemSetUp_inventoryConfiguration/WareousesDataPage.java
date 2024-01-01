package systemSetUp_inventoryConfiguration;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Pages.pagesBase;

public class WareousesDataPage extends pagesBase{

	public WareousesDataPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (css = "a[href=\"/stp/inv/warehousedetail/list\"]")
	public WebElement allLink ;
	
	@FindBy (xpath = "//*[@id=\"wrhsData63_content_table\"]/tbody/tr[5]")
	WebElement warehouseRecord ;
	
	@FindBy (xpath = "//*[@id=\"wrhsData63_toolbarItems\"]/div/div[1]/div[2]")
	WebElement viewIcon ;
	
	@FindBy (xpath = "//*[@id=\"quick-menu-body\"]/li[6]/button")
	WebElement printButton ;
	
	@FindBy (css = "button.btn.btn-sm.btn-primary.w-25")
	WebElement runReportBtn ;
	
	@FindBy (css = "div[style = 'overflow:hidden;max-width:225.37pt;width:225.37pt;display:table-cell;text-align:left;justify-content:flex-start;']")
	public WebElement ensurePrintDataRight ;
	
	@FindBy (css = "div[title = 'Modify']")
	WebElement updateButton ;
	
	@FindBy (css = "button[title = 'Save']")
	WebElement saveButton ;
	
	@FindBy (xpath = "//*[@id=\"wrhsData63_content_table\"]/tbody/tr[10]")
	WebElement selectItemRow;
	
	@FindBy (css = "input[name= 'whLNm']")
	public WebElement whName ;
	
	@FindBy (css = "input[name= 'addrs']")
	WebElement whAddress ;
	
	@FindBy (css = "input[aria-owns='untNo_options']")
	WebElement operationUnitList ;
	
	@FindBy (css = "input[placeholder= 'Emp. Code']")
	WebElement employeeCodeList ;
	
	@FindBy (css = "input[placeholder='Geographical Location']")
	WebElement geographicLocation ;
	
	@FindBy (css = "textarea[name= 'notes']")
	WebElement Remarks ;
	
	@FindBy (css = "input[name= 'noSalFlg']")
	WebElement notForSaleCheckBox ;
	
	@FindBy (css = "input[name= 'whMainFlg']")
	WebElement mainWareHouseCheckBox ;
	
	@FindBy (css = "input[placeholder= 'From Date']")
	WebElement f_Date ;
	
	@FindBy (css = "input[placeholder= 'To Date']")
	WebElement t_Date ;
	
	@FindBy (css = "input[placeholder='Cost Center No.']")
	WebElement costCenterNo ;
	
	@FindBy (css = "input[placeholder='Sub Ledger2 No.']")
	WebElement subLedger2No ;
	
	@FindBy (css = "button[title= 'Modify']")
	WebElement ModifyButton ;
	
	
	public void viewWarehouseScreen () 
	{
		clickBtn(warehouseRecord);
		clickBtn(viewIcon);
	}
	
	public void printReport () 
	{
		clickBtn(printButton);
		clickBtn(runReportBtn);
	}
	
	public void openWarehouseUpdateScreen () 
	{
		clickBtn(selectItemRow);
		clickBtn(updateButton);
	}
	
	public void updateWarehouseData (String WarehouseName , String WarehouseAddress , String OperationUnit , String EmployeeName , String LocationName , String Notes , String FromDate , String ToDate , String CostCenterName ,String Subledger2Name) throws AWTException 
	{
		whName.clear();
		sendTxtToInputTxt(whName, WarehouseName);
		whAddress.clear();
		sendTxtToInputTxt(whAddress, WarehouseAddress);
		//clearInputText(operationUnitList);
		sendTxtToInputTxt(operationUnitList, OperationUnit);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        employeeCodeList.clear();
		sendTxtToInputTxt(employeeCodeList, EmployeeName);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        geographicLocation.clear();
		sendTxtToInputTxt(geographicLocation, LocationName);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
		Remarks.clear();
		sendTxtToInputTxt(Remarks, Notes);
		clickBtn(mainWareHouseCheckBox);
		f_Date.clear();
		sendTxtToInputTxt(f_Date, FromDate);
		t_Date.clear();
		sendTxtToInputTxt(t_Date, ToDate);
		clearInputText(costCenterNo);
		sendTxtToInputTxt(costCenterNo, CostCenterName);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        clearInputText(subLedger2No);
		sendTxtToInputTxt(subLedger2No, Subledger2Name);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
		clickBtn(saveButton);
		//clickBtn(ModifyButton);
	}
}
