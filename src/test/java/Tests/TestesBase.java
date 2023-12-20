package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import UtilitiesORHelpers.TakeScreenShotSharedMethod;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class TestesBase extends AbstractTestNGCucumberTests {
	public static WebDriver driver;
	public static String PathDownload = System.getProperty("user.dir")+"\\Downloads";
	
	public static ChromeOptions chromeoptions () 
	{
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory",PathDownload );
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}
	
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName) 
	{
		if (browserName.equalsIgnoreCase("chrome")) {
			String path = System.getProperty("user.dir")+"\\Drivers_New_Vesions1\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path);
			driver = new ChromeDriver(chromeoptions());
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			String path = System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", path);
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			String path = System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe";
			System.setProperty("webdriver.edge.driver", path);
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	
	// Taking ScreenShot After Failed Methods And But It At screenShots Files 
		@AfterMethod 
		public void takeScreenshotsOnFaliure (ITestResult result) throws IOException 
		{
			if (result.getStatus() == ITestResult.FAILURE) {
				System.out.println("Failed!");
				System.out.print("screenShot Taking....");
				TakeScreenShotSharedMethod.takeScreenShotsAtFailure(driver, result.getName());
			}
		}
		
	@AfterSuite
	public void closeDriver() 
	{
		driver.close();
	}
	
	
}
