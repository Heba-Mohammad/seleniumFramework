package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndPropertiesFile extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String firstname= LoadProperties.userData.getProperty("firstname");
	String lastname= LoadProperties.userData.getProperty("lastname");
	String email= LoadProperties.userData.getProperty("email");
	String password= LoadProperties.userData.getProperty("password");
	
	
	@Test(priority = 1 , alwaysRun = true)
	public void UserCanRegisterSuccssfully()
	{
		homeObject= new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(firstname, lastname,email ,password );
		
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	@Test (dependsOnMethods = ("UserCanRegisterSuccssfully"))
	public void RegisteredUserCanLogin()
	{
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.UserLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		
	}
	
	
	
}
