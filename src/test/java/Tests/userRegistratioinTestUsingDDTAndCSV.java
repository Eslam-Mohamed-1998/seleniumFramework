package Tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import Pages.homePage;
import Pages.logOutPage;
import Pages.loginPage;
import Pages.userRegistrationPage;


public class userRegistratioinTestUsingDDTAndCSV extends TestesBase {
	homePage homeObject;
	userRegistrationPage userRegisterObject ;
	loginPage loginObject ;
	logOutPage logOutObject ;
	
	CSVReader reader ;
	
	@Test (priority = 1 , alwaysRun = true )
	public void userCanRegistration () throws 
CsvValidationException, IOException
	{
		String csvFile = System.getProperty("user.dir") + "//src/test//java//testData//UserData.csv" ;
		reader = new CSVReader(new FileReader(csvFile));
		String [] csvCell ;
		while ((csvCell = reader.readNext()) != null) {
			String fName = csvCell[0];
			String lName = csvCell[1];
			String email = csvCell[2];
			String pass = csvCell[3];

		homeObject = new homePage(driver);
		logOutObject = new logOutPage(driver);
		homeObject.openRegistrationPage();
		userRegisterObject = new userRegistrationPage(driver);
		userRegisterObject.userRegistration(fName, lName, email, pass);
		//Thread.sleep(2000);
		Assert.assertTrue(userRegisterObject.successMsg.getText().contains("Your registration completed"));
		//logOutObject.userCanLogOut();
		homeObject.openLoginPage();
		loginObject = new loginPage(driver);
		loginObject.userCanLogin(email, pass);
		Assert.assertTrue(loginObject.logoutBtn.getText().contains("Log out"));
		logOutObject.userCanLogOut();
		}
	}
	@Test (dependsOnMethods = {"userCanRegistration"} , enabled = false)
	public void registeredUserCanLogin () //throws InterruptedException 
	{
		homeObject = new homePage(driver);
		homeObject.openLoginPage();
		loginObject = new loginPage(driver);
		loginObject.userCanLogin("Eslam@Test10000.com", "123456789Eslam");
		//Thread.sleep(2000);
		Assert.assertTrue(loginObject.logoutBtn.getText().contains("Log out"));
	}
}
