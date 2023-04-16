package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase
{



	public UserRegisterationPage(WebDriver driver) 
	{
		super(driver);

	}

	@FindBy(id = "gender-male")
	WebElement genderRdoBtn;

	@FindBy(id = "FirstName")
	WebElement fnTxtBox;

	@FindBy(id = "LastName")
	WebElement lnTxtBox;

	@FindBy(id = "Email")
	WebElement emailTxtBox;

	@FindBy(id = "Password")
	WebElement passwordTxtBox;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmpasswordTxtBox;

	@FindBy(id = "register-button")
	WebElement registerBtn;

	@FindBy(css = "div.result")
	public	WebElement successMessage;

	@FindBy(className = "ico-logout")
	public	WebElement logoutLink;
	
	@FindBy(linkText = "My account")
	WebElement myAccountLink;

	public void userRegisteration(String firstName, String lastName,String email,String password)
	{
		//	genderRdoBtn.click();
		clickButton(genderRdoBtn);

		/*		fnTxtBox.sendKeys(firstName);
		lnTxtBox.sendKeys(lastName);
		emailTxtBox.sendKeys(email);
		passwordTxtBox.sendKeys(password);
		confirmpasswordTxtBox.sendKeys(password);*/

		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmpasswordTxtBox, password);

		//	registerBtn.click();
		clickButton(registerBtn);
	}

	public void userLogout() 
	{
		clickButton(logoutLink);
	}
	
	public void openMyAccountPage() 
	{
		clickButton(myAccountLink);
		
	}
}
