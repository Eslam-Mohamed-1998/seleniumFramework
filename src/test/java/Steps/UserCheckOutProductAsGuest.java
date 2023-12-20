package Steps;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import Pages.checkOutPage;
import Pages.homePage;
import Pages.orderDetailsPage;
import Pages.searchPage;
import Pages.searchProductDetailsPage;
import Pages.shoppingCartPage;
import Tests.TestesBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserCheckOutProductAsGuest extends TestesBase{
	
	searchPage searchObject;
	searchProductDetailsPage searchProductDetailsObject;
	shoppingCartPage shoppingCartObject ;
	checkOutPage checkOutObject ;
	orderDetailsPage orderDetailsObject;
	homePage homeObject ;
	public String fName = "Eslam";
	public String LName = "Mohamed";
	public String email = "Eslam@TestNew255.com";
	public String cityName = "Cairo";
	public String address1Details = "Helwan-15 May City - Building 3";
	public String postalCodeNum = "112011";
	public String phoneNum = "01016870180";
	
	@Given("The User at The  E-Commerce Home Page")
	public void the_user_at_the_e_commerce_home_page() {
		homeObject = new homePage(driver);
		Assert.assertTrue(homeObject.loginLink.getText().contains("Log in"));
	}
	@When("User Search For Specific Product Using The {string}")
	public void user_search_for_specific_product_using_the(String productName) {
		searchObject = new searchPage(driver);
		searchProductDetailsObject = new searchProductDetailsPage(driver);
		searchObject.searchForProductUsingAutoSuggest(productName);
		Assert.assertTrue(searchProductDetailsObject.anotherConfirmedProduct().contains("Asus N551J"));
	}
	@When("Add The Product to The Crtedit Cart")
	public void add_the_product_to_the_crtedit_cart() {
		searchProductDetailsObject = new searchProductDetailsPage(driver);
		searchProductDetailsObject.opencreditCartPage();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	@When("Open Check Out Product Page")
	public void open_check_out_product_page() {
		shoppingCartObject = new shoppingCartPage(driver);
		shoppingCartObject.openCheckOutPage();
	}
	@When("Click On Check Out Product As Guest button")
	public void click_on_check_out_product_as_guest_button() {
		checkOutObject = new checkOutPage(driver);
		checkOutObject.checkOutOrderASGuest();
	}
	@When("The Guest User Check Out The Product")
	public void the_guest_user_check_out_the_product() throws InterruptedException {
		checkOutObject = new checkOutPage(driver);
		checkOutObject.checkOutProductAsGuest(fName, LName, email, 3 , cityName, address1Details, postalCodeNum, phoneNum);
	}
	@When("Open Order Details Page")
	public void open_order_details_page() {
		checkOutObject = new checkOutPage(driver);
		checkOutObject.openOrderDetilsPage();
	}
	@Then("The User Can  Print The Order details")
	public void the_user_can_print_the_order_details() {
		orderDetailsObject = new orderDetailsPage(driver);
		orderDetailsObject.printOrderDetails();
	}
}
