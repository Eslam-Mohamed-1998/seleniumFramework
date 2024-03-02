package Steps;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

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
import Pages.editPaymentRequestPage;
import Pages.kashirPaymentRequestsPage;
import Tests.TestesBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MarkPaymentRequestAsPaid extends TestesBase{
	KashierLoginPage KashierLoginObject ;
	KashierDashboardPage KashierDashboardObject ;
	kashirPaymentRequestsPage paymentRequestsObject ;
	public String notes = "Just For Testing Mark Payment Request As Paid Payment" ;
	@Given("The User Start With The Login Screen Of Thge Kashir Website")
	public void the_user_start_with_the_login_screen_of_thge_kashir_website() {
		Assert.assertTrue(driver.getCurrentUrl().contains("https://portal.staging.payformance.io/en/login")); 
	}

	@When("Once He Enter The {string}")
	public void once_he_enter_the(String UserEmailOrPhoneNo) {
		KashierLoginObject = new KashierLoginPage(driver);
		KashierLoginObject.insertEmailOrPhoneNo(UserEmailOrPhoneNo);
	}

	@When("then Insert The {string} He Can Login")
	public void then_insert_the_he_can_login(String Password) {
		KashierLoginObject = new KashierLoginPage(driver);
		KashierLoginObject.login(Password);
	}

	@When("He Want To Be At Test Mode")
	public void he_want_to_be_at_test_mode() {
		KashierDashboardObject = new KashierDashboardPage(driver);
		KashierDashboardObject.switchMode();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("mode")));
	}

	@When("and Move To Payment Request Page")
	public void and_move_to_payment_request_page() {
		KashierDashboardObject = new KashierDashboardPage(driver);
		KashierDashboardObject.openPaymentPage();
	}

	@When("He Want To Add New Payment Request")
	public void he_want_to_add_new_payment_request() {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		paymentRequestsObject.addPaymentRequest();
	}

	@When("So He Must To Insert Valid {string} and Valid {string} and Click On Add")
	public void so_he_must_to_insert_valid_and_valid_and_click_on_add(String Customername, String Amonut) {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		paymentRequestsObject.confirmPaymentRequestData(Customername, Amonut, notes);
	}

	@When("Mark The Payment Request as Paid and Confirm That")
	public void mark_the_payment_request_as_paid_and_confirm_that() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("markAsPaid")));
		paymentRequestsObject.markAsPaid();
		Thread.sleep(Duration.ofSeconds(3));
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("sureModalBox")));
		paymentRequestsObject.confirmMarkAsPaid();
		Thread.sleep(Duration.ofSeconds(3));
	}

	@Then("Check That The Payment request Is Already Be Paid Status")
	public void check_that_the_payment_request_is_already_be_paid_status() throws IOException {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.className("success")));
		String actualResult1 = paymentRequestsObject.paidSuccessLabel.getText();
		String expextedResult1 = "PAID" ;
		Assert.assertEquals(actualResult1, expextedResult1);
		TakesScreenshot tkScreen = (TakesScreenshot) driver ;
		File source = tkScreen.getScreenshotAs(OutputType.FILE);
		String screenshotName = "PaymentRequest_Mark_As_Paid";
		FileUtils.copyFile(source, new File("./screenShots/" + screenshotName + ".png"  ) );
	}
}
