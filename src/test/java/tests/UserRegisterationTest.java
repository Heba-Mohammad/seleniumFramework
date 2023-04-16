package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	
	@Test(priority = 1 , alwaysRun = true)
	public void UserCanRegisterSuccssfully()
	{
		homeObject= new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration("Heba", "Mohamed", "test139@gmail.com", "123456789");
		
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
/*	@Test (dependsOnMethods = ("UserCanRegisterSuccssfully"))
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();
		
	}*/
	
	
	
	@Test (dependsOnMethods = ("UserCanRegisterSuccssfully"))
	public void RegisteredUserCanLogin()
	{
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.UserLogin("test139@gmail.com", "123456789");
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		
	}
	
	
	
}
