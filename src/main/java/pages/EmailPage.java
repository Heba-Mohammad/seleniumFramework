package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{

	public EmailPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FriendEmail")
	WebElement emailFriendTxt;
	
	@FindBy(id = "PersonalMessage")
	WebElement personalMessageTxt;
	
	@FindBy(css = "button.button-1.send-email-a-friend-button")
	WebElement sendEmailBtn;
	
	@FindBy(css = "div.result")
	public WebElement messageNotification;
	
	public void sendEmailToFriend(String friendEmail,String  personalMessage)
	{
		setTextElementText(emailFriendTxt, friendEmail);
		setTextElementText(personalMessageTxt, personalMessage);
		clickButton(sendEmailBtn);
	}
}
