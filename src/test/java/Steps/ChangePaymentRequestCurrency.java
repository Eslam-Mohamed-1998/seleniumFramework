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

public class ChangePaymentRequestCurrency extends TestesBase{
	KashierLoginPage KashierLoginObject ;
	KashierDashboardPage KashierDashboardObject ;
	kashirPaymentRequestsPage paymentRequestsObject ;
	public String notes = "Just For Testing Change The Curreny Successfully" ;
	@Given("The Website Of Kashir Login page is The Beginning")
	public void the_website_of_kashir_login_page_is_the_beginning() {
		Assert.assertTrue(driver.getCurrentUrl().contains("https://portal.staging.payformance.io/en/login"));
	}

	@When("Move To Enter {string}")
	public void move_to_enter(String EmailAddressOrPhoneNo) {
		KashierLoginObject = new KashierLoginPage(driver);
		KashierLoginObject.insertEmailOrPhoneNo(EmailAddressOrPhoneNo);
	}

	@When("then Insert The User {string} and Continue to Login Action")
	public void then_insert_the_user_and_continue_to_login_action(String Pass) {
		KashierLoginObject = new KashierLoginPage(driver);
		KashierLoginObject.login(Pass);
	}

	@When("The User need to Be At test Mode")
	public void the_user_need_to_be_at_test_mode() {
		KashierDashboardObject = new KashierDashboardPage(driver);
		KashierDashboardObject.switchMode();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("mode")));
	}

	@When("He Need to Navigate To Payment Request page")
	public void he_need_to_navigate_to_payment_request_page() {
		KashierDashboardObject = new KashierDashboardPage(driver);
		KashierDashboardObject.openPaymentPage();
	}

	@When("Change The Payment Currency To USD")
	public void change_the_payment_currency_to_usd() {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		paymentRequestsObject.changeCurrency();
	}

	@When("and Try To Add or Create New Payment Request")
	public void and_try_to_add_or_create_new_payment_request() {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		paymentRequestsObject.addPaymentRequest();
	}

	@When("Will Be Able To Enter {string} and {string} and click On Add")
	public void will_be_able_to_enter_and_and_click_on_add(String Cus_Name, String Amount) {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		paymentRequestsObject.confirmPaymentRequestData(Cus_Name, Amount, notes);
	}

	@Then("Check That The total amount Is In USD Currency")
	public void check_that_the_total_amount_is_in_usd_currency() throws IOException {
		paymentRequestsObject = new kashirPaymentRequestsPage(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-dashboard/div/app-view-payment-request/div/div/div[1]/div[1]/h3")));
		String actualResult1 = paymentRequestsObject.amountInUSDCurrencyLabel.getText();
		String expextedResult1 = "1000 USD" ;
		Assert.assertEquals(actualResult1, expextedResult1);
		TakesScreenshot tkScreen = (TakesScreenshot) driver ;
		File source = tkScreen.getScreenshotAs(OutputType.FILE);
		String screenshotName = "PaymentRequest_After_Change_Currency";
		FileUtils.copyFile(source, new File("./screenShots/" + screenshotName + ".png"  ) );
	}
}
