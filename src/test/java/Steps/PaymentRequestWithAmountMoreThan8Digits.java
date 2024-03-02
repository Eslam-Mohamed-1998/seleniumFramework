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

public class PaymentRequestWithAmountMoreThan8Digits extends TestesBase {
	KashierLoginPage KashierLoginObject ;
	KashierDashboardPage KashierDashboardObject ;
	kashirPaymentRequestsPage paymentRequestsObject ;
	public String notes = "Just For Testing With Amount More Than 8 Digits" ;
	@Given("User Open The Kshir Login Screen")
	public void user_open_the_kshir_login_screen() {
	     Assert.assertTrue(driver.getCurrentUrl().contains("https://portal.staging.payformance.io/en/login")); 
	}

	@When("Insert {string}")
	public void insert(String Email) {
		KashierLoginObject = new KashierLoginPage(driver);
		KashierLoginObject.insertEmailOrPhoneNo(Email);
	}

	@When("Insert {string} then login")
	public void insert_then_login(String Pass) {
		KashierLoginObject = new KashierLoginPage(driver);
		KashierLoginObject.login(Pass);
	}

	@When("User Be At Test Mode")
	public void user_be_at_test_mode() {
		KashierDashboardObject = new KashierDashboardPage(driver);
		KashierDashboardObject.switchMode();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("mode")));
	}

	@When("User Be At Payment Request Page")
	public void user_be_at_payment_request_page() {
		KashierDashboardObject = new KashierDashboardPage(driver);
		KashierDashboardObject.openPaymentPage();
	}

	@When("Try To Add New Payment Request")
	public void try_to_add_new_payment_request() {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		paymentRequestsObject.addPaymentRequest();
	}

	@When("The User Enter it is {string} and it is {string}")
	public void the_user_enter_it_is_and_it_is(String Cus_Name, String total_amount) {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		paymentRequestsObject.confirmPaymentRequestData(Cus_Name, total_amount, notes);
	}

	@Then("An Hint Message Input must be Six or Eight digits & unique. Is Appear")
	public void an_hint_message_input_must_be_six_or_eight_digits_unique_is_appear() throws IOException {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		String actualResult1 = paymentRequestsObject.acceptedAmountDigitsMessage.getText();
		String expextedResult1 = "Input must be 6 or 8 digits & unique." ;
		Assert.assertEquals(actualResult1, expextedResult1);
		TakesScreenshot tkScreen = (TakesScreenshot) driver ;
		File source = tkScreen.getScreenshotAs(OutputType.FILE);
		String screenshotName = "PaymentRequest_With_Amount_More_Than_Accepted_No_Of_Digits";
		FileUtils.copyFile(source, new File("./screenShots/" + screenshotName + ".png"  ) );
	}
}
