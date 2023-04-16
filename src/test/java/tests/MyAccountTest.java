package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registerObject;
	MyAccountPage myAccountObject;
	LoginPage loginObject;

	String oldPassword="123456789";
	String newPassword="123456";
	String firstName="Heba";
	String lastName="Mohamed";
	String email="test151@gmail.com";


	@Test(priority = 1 , alwaysRun = true)
	public void UserCanRegisterSuccssfully()
	{
		homeObject= new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, oldPassword);

		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}


	@Test (dependsOnMethods = ("UserCanRegisterSuccssfully"))
	public void RegisteredUserCanLogin()
	{
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.UserLogin(email, oldPassword);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}


	@Test (dependsOnMethods = ("RegisteredUserCanLogin"))
	public void RegisteredUserCanChangePassword()
	{

		myAccountObject= new MyAccountPage(driver);
		myAccountObject.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.ChangePassword(oldPassword, newPassword);

		//	myAccountObject.openChangePasswordPage();
		Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password was changed"));
		myAccountObject.closeChanePasswordMessage();

	}

	@Test (dependsOnMethods = ("UserCanRegisterSuccssfully"))
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();

	}

	@Test (dependsOnMethods = ("RegisteredUserCanLogout"))
	public void RegisteredUserCanLoginWithNewPassword()
	{
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.UserLogin(email, newPassword);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));

	}



}
