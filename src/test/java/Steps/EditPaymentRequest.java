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

public class EditPaymentRequest extends TestesBase{
	KashierLoginPage KashierLoginObject ;
	KashierDashboardPage KashierDashboardObject ;
	kashirPaymentRequestsPage paymentRequestsObject ;
	editPaymentRequestPage editPaymentRequestObject ;
	public String notes = "Just For Testing The Update Method Successfully " ;
	@Given("User Start With Kashir Login Page")
	public void user_start_with_kashir_login_page() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("https://portal.staging.payformance.io/en/login")); 
	}

	@When("User Begin To Enter {string}")
	public void user_begin_to_enter(String UserEmail) {
		KashierLoginObject = new KashierLoginPage(driver);
		KashierLoginObject.insertEmailOrPhoneNo(UserEmail);
	}

	@When("and Enter The {string} then Login To The Website")
	public void and_enter_the_then_login_to_the_website(String UserPassword) {
		KashierLoginObject = new KashierLoginPage(driver);
		KashierLoginObject.login(UserPassword);
	}

	@When("Test Mode Is Switched")
	public void test_mode_is_switched() {
		KashierDashboardObject = new KashierDashboardPage(driver);
		KashierDashboardObject.switchMode();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("mode")));
	}

	@When("Payment Request Page Is Open")
	public void payment_request_page_is_open() {
		KashierDashboardObject = new KashierDashboardPage(driver);
		KashierDashboardObject.openPaymentPage();
	}

	@When("User Click On Payment Request Add button")
	public void user_click_on_payment_request_add_button() {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		paymentRequestsObject.addPaymentRequest();
	}

	@When("Enter The {string} and {string} and click On Add Btn")
	public void enter_the_and_and_click_on_add_btn(String CusName, String TotalAmount) {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		paymentRequestsObject.confirmPaymentRequestData(CusName, TotalAmount, notes);
	}

	@When("click On Edit Request Data button")
	public void click_on_edit_request_data_button() throws InterruptedException {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("editPaymentRequest")));
		paymentRequestsObject.editPaymentRequest();
		Thread.sleep(Duration.ofSeconds(3));
	}

	@When("Change The Request {string} and {string} then click On Save button")
	public void change_the_request_and_then_click_on_save_button(String NewCusName, String NewAmount) {
		//WebDriverWait wait2 = new WebDriverWait(driver, 20);
		//wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\\\"customerName\\\"]")));
		editPaymentRequestObject = new editPaymentRequestPage(driver);
		editPaymentRequestObject.updateRequestData(NewCusName, NewAmount);
	}

	@Then("Check That The Updated Successfully Alret Message Is Appear")
	public void check_that_the_updated_successfully_alret_message_is_appear() throws IOException, InterruptedException {
		editPaymentRequestObject = new editPaymentRequestPage(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/div/k-toastr/div/div/div/p")));
		String actualResult1 = editPaymentRequestObject.updateSuccessfullyAlret.getText();
		String expextedResult1 = "The Payment Request has been updated [success]" ;
		//Assert.assertEquals(actualResult1, expextedResult1);
		TakesScreenshot tkScreen = (TakesScreenshot) driver ;
		File source = tkScreen.getScreenshotAs(OutputType.FILE);
		String screenshotName = "PaymentRequest_Update_Successfully";
		FileUtils.copyFile(source, new File("./screenShots/" + screenshotName + ".png"  ) );
	}
}
