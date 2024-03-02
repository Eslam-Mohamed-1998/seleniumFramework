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
import Pages.kashirPaymentRequestsPage;
import Pages.pagesBase;
import Tests.TestesBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class deletePaymentRequest extends TestesBase{
	KashierLoginPage KashierLoginObject ;
	KashierDashboardPage KashierDashboardObject ;
	kashirPaymentRequestsPage paymentRequestsObject ;
	public String notes = "Just For Testing Deleting Payment Request Successfully" ;
	@Given("The Kahir Login Page Is The Beginning")
	public void the_kahir_login_page_is_the_beginning() {
		Assert.assertTrue(driver.getCurrentUrl().contains("https://portal.staging.payformance.io/en/login"));
	}

	@When("Strat With Insertion {string}")
	public void strat_with_insertion(String UserEmailOrPhoneNo) {
		KashierLoginObject = new KashierLoginPage(driver);
		KashierLoginObject.insertEmailOrPhoneNo(UserEmailOrPhoneNo);
	}

	@When("then Move To Insertion The {string} and Click On Login button")
	public void then_move_to_insertion_the_and_click_on_login_button(String Pass) {
		KashierLoginObject = new KashierLoginPage(driver);
		KashierLoginObject.login(Pass);
	}

	@When("The Test Mode is Active")
	public void the_test_mode_is_active() {
		KashierDashboardObject = new KashierDashboardPage(driver);
		KashierDashboardObject.switchMode();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("mode")));
	}

	@When("Navigate To Create Payment Request Screen")
	public void navigate_to_create_payment_request_screen() {
		KashierDashboardObject = new KashierDashboardPage(driver);
		KashierDashboardObject.openPaymentPage();
	}

	@When("User Create Add New Payment Request")
	public void user_create_add_new_payment_request() {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		paymentRequestsObject.addPaymentRequest();
	}

	@When("He Will Resposible To Insert {string} and {string}")
	public void he_will_resposible_to_insert_and(String CustomerName, String amount) {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		paymentRequestsObject.confirmPaymentRequestData(CustomerName, amount, notes);
	}

	@When("Click On Delete Payment Request button")
	public void click_on_delete_payment_request_button() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("deletePaymentRequest")));
		paymentRequestsObject.deletePaymentRequest();
		Thread.sleep(Duration.ofSeconds(3));
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[value='Delete']")));
		paymentRequestsObject.confirmdDeletePaymentRequest();
		Thread.sleep(Duration.ofSeconds(3));
	}
	
	@Then("Check That Payment request Delted Successfully alret Is Appeqr")
	public void check_that_payment_request_delted_successfully_alret_is_appeqr() throws IOException, InterruptedException {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/div/k-toastr/div/div/div/p")));
		String actualResult1 = paymentRequestsObject.deltedSucessfulltMessage.getText();
		String expextedResult1 = "The Payment Request has been deleted [success]" ;
		Assert.assertEquals(actualResult1, expextedResult1);
		TakesScreenshot tkScreen = (TakesScreenshot) driver ;
		File source = tkScreen.getScreenshotAs(OutputType.FILE);
		String screenshotName = "PaymentRequest_Deleted_Successfully";
		FileUtils.copyFile(source, new File("./screenShots/" + screenshotName + ".png"  ) );
		Thread.sleep(Duration.ofSeconds(40));
	}
}
