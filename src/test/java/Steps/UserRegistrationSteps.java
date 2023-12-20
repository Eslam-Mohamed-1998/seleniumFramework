package Steps;

import org.testng.Assert;

import com.github.javafaker.Faker;

import Pages.homePage;
import Pages.userRegistrationPage;
import Tests.TestesBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistrationSteps extends TestesBase{
	homePage homeObject ;
	userRegistrationPage userRegistrationobject ;
	//Faker fakeData = new Faker();
	//String fName = fakeData.name().firstName();
	//String lName = fakeData.name().lastName();
	//String email = fakeData.internet().emailAddress();
	//String pass = fakeData.number().digits(10).toString();

	
	@Given("The User Open The Website LandPage")
	public void the_user_open_the_website_land_page() {
		homeObject = new homePage(driver);
		Assert.assertTrue(homeObject.loginLink.getText().contains("Log in"));
	}
	
	@When("The User Click On Register button")
	public void the_user_click_on_register_button() {
		homeObject = new homePage(driver);
		homeObject.openRegistrationPage();
	}
	
	
	/*
	 * @And("Enter The Right Data") public void enter_the_right_data() {
	 * userRegistrationobject = new userRegistrationPage(driver);
	 * userRegistrationobject.userRegistration(fName, lName, email, pass); }
	 */
	
	@When("Enter The {string} , {string} , {string} , {string}")
    public void enterUserDetails(String fName, String lName, String email, String pass) {
		userRegistrationobject = new userRegistrationPage(driver);
		userRegistrationobject.userRegistration(fName, lName, email, pass);
    }


	
	@Then("The Registration Success Message Is appeared")
	public void the_registration_success_message_is_appeared() {
	    Assert.assertTrue(userRegistrationobject.successMsg.isDisplayed());
	}
}
