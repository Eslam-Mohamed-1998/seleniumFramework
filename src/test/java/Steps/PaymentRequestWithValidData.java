package Steps;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.CSS;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.dockerjava.api.model.Driver;
import com.mifmif.common.regex.util.Iterator;

import Pages.KashierDashboardPage;
import Pages.KashierLoginPage;
import Pages.KashierPaymentPage;
import Pages.kashirPaymentRequestsPage;
import Tests.TestesBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentRequestWithValidData extends TestesBase{
	KashierLoginPage KashierLoginObject ;
	KashierDashboardPage KashierDashboardObject ;
	kashirPaymentRequestsPage paymentRequestsObject ;
	KashierPaymentPage KashierPaymentObject ;
	public String notes = "Just For Testing" ;
	@Given("The User at Kahier Login Page")
	public void the_user_at_kahier_login_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("https://portal.staging.payformance.io/en/login")); 
	}

	@When("Insert {string} and Click On Next button")
	public void insert_and_click_on_next_button(String EmailAddressOrPhoneNo) {
		KashierLoginObject = new KashierLoginPage(driver);
		KashierLoginObject.insertEmailOrPhoneNo(EmailAddressOrPhoneNo);
	}

	@When("Insert {string} And Click On Login button")
	public void insert_and_click_on_login_button(String Password) {
		KashierLoginObject = new KashierLoginPage(driver);
		KashierLoginObject.login(Password);
	}

	@When("Switch To Test Mode")
	public void switch_to_test_mode() {
		KashierDashboardObject = new KashierDashboardPage(driver);
		KashierDashboardObject.switchMode();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("mode")));
	}

	@When("Open Payment Request page")
	public void open_payment_request_page() {
		KashierDashboardObject = new KashierDashboardPage(driver);
		KashierDashboardObject.openPaymentPage();
	}

	@When("Click On Add Payment Request button")
	public void click_on_add_payment_request_button() {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		paymentRequestsObject.addPaymentRequest();
	}

	@When("Enter Valid {string} and {string} and Click On add button")
	public void enter_valid_and_and_click_on_add_button(String CustomerName, String Amount) {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		paymentRequestsObject.confirmPaymentRequestData(CustomerName, Amount, notes);
	}

	@When("Click On Share button then Click On Redirection Link Icon")
	public void click_on_share_button_then_click_on_redirection_link_icon() throws IOException {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		paymentRequestsObject.openShareLink();
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.visibilityOfAllElements(paymentRequestsObject.alretMessage));
		//String actualResult = paymentRequestsObject.alretMessage.getText() ;
		//System.out.println(actualResult);
		//String expextedResult = "Payment request saved";
		//Assert.assertEquals(actualResult, expextedResult);
		TakesScreenshot tkScreen = (TakesScreenshot) driver ;
		File source = tkScreen.getScreenshotAs(OutputType.FILE);
		String screenshotName = "Payment_Saved_Successfully";
		FileUtils.copyFile(source, new File("./screenShots/" + screenshotName + ".png"  ) );
	}

	@When("Accept Terms and Condations and Click On Pay Now button")
	public void accept_terms_and_condations_and_click_on_pay_now_button() throws InterruptedException, IOException {
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		java.util.Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
			}
		}
		KashierPaymentObject = new KashierPaymentPage(driver);
		KashierPaymentObject.paynowConfirmation();
		WebElement iframeElement = driver.findElement(By.cssSelector("iframe[id='iFrame']"));
		driver.switchTo().frame(iframeElement);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement paymentCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("payment-header-div")));
		//Thread.sleep(Duration.ofSeconds(40));
		KashierPaymentObject = new KashierPaymentPage(driver);
		KashierPaymentObject.setPaymentDetails();
		driver.switchTo().defaultContent();
		Thread.sleep(Duration.ofSeconds(20));
		WebElement iframeElement2 = driver.findElement(By.cssSelector("iframe[name='challengeFrame']"));
		driver.switchTo().frame(iframeElement2);
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("challengeFrame")));
		WebDriverWait wait3 = new WebDriverWait(driver, 20);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("acssubmit")));
		KashierPaymentObject = new KashierPaymentPage(driver);
		KashierPaymentObject.accSubmit();
		driver.switchTo().defaultContent();
		Thread.sleep(Duration.ofSeconds(7));
		TakesScreenshot tkScreen = (TakesScreenshot) driver ;
		File source = tkScreen.getScreenshotAs(OutputType.FILE);
		String screenshotName = "Paid_Successfully";
		FileUtils.copyFile(source, new File("./screenShots/" + screenshotName + ".png"  ) );
		//Check The Number Of Window Handler 
		int initialWindowCount = driver.getWindowHandles().size();
		System.out.println(initialWindowCount);
		driver.switchTo().window(parent);
	}

	@Then("Back To The Payment Request To Check That Payment Request Reflect At The Payment Requests List")
	public void back_to_the_payment_request_to_check_that_payment_request_reflect_at_the_payment_requests_list() {
		KashierPaymentObject = new KashierPaymentPage(driver);
		KashierPaymentObject.closePaymentRequest();
		String actualResult1 = KashierPaymentObject.PaymentRequestStatusLabel.getText();
		String expextedResult1 = "PAID" ;
		Assert.assertEquals(actualResult1, expextedResult1);
	}
}
