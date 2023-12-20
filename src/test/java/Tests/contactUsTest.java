package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.contactUSPage;
import Pages.homePage;

public class contactUsTest extends TestesBase {
	homePage homeobject;
	contactUSPage contactUsObject;
	
	public String fullName = "Eslam Mohamed Abdallah";
	public String Email = "Eslam@Test2.com";
	public String Message = "This Is Only For Tresting For the Second Time ";
	@Test
	public void userCanSendMessageFromContactUsPage() 
	{
		homeobject = new homePage(driver);
		contactUsObject = new contactUSPage(driver);
		homeobject.opencontactUsPage();
		contactUsObject.contactUsSendMessage(fullName, Email, Message);
		Assert.assertTrue(contactUsObject.successMessage.getText().contains("Your enquiry has been successfully sent to the store owne"));
	}
}
