package Steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.KashierDashboardPage;
import Pages.KashierLoginPage;
import Pages.kashirPaymentRequestsPage;
import Tests.TestesBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentRequestWithEmptyCustomernameAndAmount extends TestesBase{
	KashierLoginPage KashierLoginObject ;
	KashierDashboardPage KashierDashboardObject ;
	kashirPaymentRequestsPage paymentRequestsObject ;
	public String notes = "Just For Testing With Empty Customer Name And Empty Amount" ;
	@Given("The User Open Kashir Login Page")
	public void the_user_open_kashir_login_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("https://portal.staging.payformance.io/en/login"));
	}

	@When("Enter {string} and click On Next button")
	public void enter_and_click_on_next_button(String Email) {
		KashierLoginObject = new KashierLoginPage(driver);
		KashierLoginObject.insertEmailOrPhoneNo(Email);
	}

	@When("Enter {string} then Click On Login")
	public void enter_then_click_on_login(String Password) {
		KashierLoginObject = new KashierLoginPage(driver);
		KashierLoginObject.login(Password);
	}

	@When("Swap To The Test Mode")
	public void swap_to_the_test_mode() {
		KashierDashboardObject = new KashierDashboardPage(driver);
		KashierDashboardObject.switchMode();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("mode")));
	}

	@When("Navigate To Payment Request Page")
	public void navigate_to_payment_request_page() {
		KashierDashboardObject = new KashierDashboardPage(driver);
		KashierDashboardObject.openPaymentPage();
	}

	@When("Add New Payment Request")
	public void add_new_payment_request() {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		paymentRequestsObject.addPaymentRequest();
	}

	@When("Enter Empty {string} and Empty {string} and Click On add Button")
	public void enter_empty_and_empty_and_click_on_add_button(String CustomerName, String Amount) {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		paymentRequestsObject.confirmPaymentRequestWithEmptyData(CustomerName, Amount, notes);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(paymentRequestsObject.customerNameRequiredMessage));
	}

	@Then("An Hint Message Will Appear This Field Is Required")
	public void an_hint_message_will_appear_this_field_is_required() throws IOException {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		String actualResult1 = paymentRequestsObject.customerNameRequiredMessage.getText();
		String expextedResult1 = "This field is required." ;
		Assert.assertEquals(actualResult1, expextedResult1);
		String actualResult2 = paymentRequestsObject.amountRequiredMessage.getText();
		String expextedResult2 = "This field is required." ;
		Assert.assertEquals(actualResult2, expextedResult2);
		TakesScreenshot tkScreen = (TakesScreenshot) driver ;
		File source = tkScreen.getScreenshotAs(OutputType.FILE);
		String screenshotName = "PaymentRequest_With_empty_data";
		FileUtils.copyFile(source, new File("./screenShots/" + screenshotName + ".png"  ) );
	}
}
