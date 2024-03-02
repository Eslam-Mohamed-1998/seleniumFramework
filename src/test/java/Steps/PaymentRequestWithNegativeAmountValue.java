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
import Pages.KashierPaymentPage;
import Pages.kashirPaymentRequestsPage;
import Tests.TestesBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentRequestWithNegativeAmountValue extends TestesBase {
	KashierLoginPage KashierLoginObject ;
	KashierDashboardPage KashierDashboardObject ;
	kashirPaymentRequestsPage paymentRequestsObject ;
	public String notes = "Just For Testing With Negative Amount Value" ;
	@Given("The User Be At Kahir Loging Page")
	public void the_user_be_at_kahir_loging_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("https://portal.staging.payformance.io/en/login"));
	}

	@When("Enter Valid {string} and Click On Next")
	public void enter_valid_and_click_on_next(String UserEmail) {
		KashierLoginObject = new KashierLoginPage(driver);
		KashierLoginObject.insertEmailOrPhoneNo(UserEmail);
	}

	@When("Enter Valid {string} and Click On Login")
	public void enter_valid_and_click_on_login(String UserPassword) {
		KashierLoginObject = new KashierLoginPage(driver);
		KashierLoginObject.login(UserPassword);
	}

	@When("Move To Test Mode")
	public void move_to_test_mode() {
		KashierDashboardObject = new KashierDashboardPage(driver);
		KashierDashboardObject.switchMode();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("mode")));
	}

	@When("Open The Payment Request Screen")
	public void open_the_payment_request_screen() {
		KashierDashboardObject = new KashierDashboardPage(driver);
		KashierDashboardObject.openPaymentPage();
	}

	@When("Click Add New Payment Request")
	public void click_add_new_payment_request() {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		paymentRequestsObject.addPaymentRequest();
	}
	
	@When("User Insert Valid {string} and {string} and Click On add button")
	public void User_Insert_valid_and_and_click_on_add_button(String CustomerName, String MinusAmountValue) {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		paymentRequestsObject.confirmPaymentRequestData(CustomerName, MinusAmountValue, notes);
	}

	@Then("An Alret Message That The Total amount Must Be Greater Than Zero Is appear")
	public void an_alret_message_that_the_total_amount_must_be_greater_than_zero_is_appear() throws IOException {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		String actualResult = paymentRequestsObject.totalAmountValidationMessage.getText();
		System.out.println(actualResult);
		String expectedResult = "totalAmount This field must be a number greater than or equal to the minimum" ;
		Assert.assertEquals(actualResult, expectedResult);
		TakesScreenshot tkScreen = (TakesScreenshot) driver ;
		File source = tkScreen.getScreenshotAs(OutputType.FILE);
		String screenshotName = "PaymentRequest_With_Minus_Amount_Value";
		FileUtils.copyFile(source, new File("./screenShots/" + screenshotName + ".png"  ) );
	}
}
