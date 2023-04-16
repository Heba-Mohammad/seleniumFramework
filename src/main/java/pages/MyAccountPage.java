package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(linkText ="Change password" )
	WebElement changePasswordLink;

	public void openChangePasswordPage()
	{
		clickButton(changePasswordLink);
	}

	@FindBy(linkText = "My account")
	WebElement openMyAccountLink;

	public void openMyAccountPage()
	{
		clickButton(openMyAccountLink);
	}

	public void closeChanePasswordMessage()
	{
		clickButton(resultClose);
	}

	@FindBy (id = "OldPassword")
	WebElement oldPasswordTxt;

	@FindBy(id = "NewPassword")
	WebElement newPasswordTxt;

	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmPasswordTxt;

	@FindBy(css = "button.button-1.change-password-button")
	WebElement changePasswordBtn;

	@FindBy(css = "div.bar-notification.success")
	public	WebElement resultLbl;

	@FindBy(css = "span.close")
	WebElement resultClose;


	public void ChangePassword(String oldPassword, String newPassword) {
		setTextElementText(oldPasswordTxt, oldPassword);
		setTextElementText(newPasswordTxt, newPassword);
		setTextElementText(confirmPasswordTxt, newPassword);
		clickButton(changePasswordBtn);

	}
}



