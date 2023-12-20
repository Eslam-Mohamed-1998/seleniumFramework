package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class emailFriendPage extends pagesBase{

	public emailFriendPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FriendEmail")
	WebElement myFriendEmailInputTxt ;

	@FindBy(id = "PersonalMessage")
	WebElement myPersonalMessageTxtArea ;

	@FindBy (css = "button.button-1.send-email-a-friend-button")
	WebElement sendEmailBtn ;

	@FindBy (css = "div.result")
	public WebElement successSendEmailMessgae ;
	
	public void sendProductForEmailFriend(String friendEmail , String textMessage) 
	{
		sendTxtToInputTxt(myFriendEmailInputTxt, friendEmail);
		sendTxtToInputTxt(myPersonalMessageTxtArea, textMessage);
		clickBtn(sendEmailBtn);
	}
}
