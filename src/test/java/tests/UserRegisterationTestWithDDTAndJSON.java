package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JasonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithDDTAndJSON extends TestBase
{
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;


	@Test(priority = 1 , alwaysRun = true)
	public void UserCanRegisterSuccssfully() throws FileNotFoundException, IOException, ParseException
	{
		JasonDataReader jasonReader= new JasonDataReader();
		jasonReader.JasonReader();
		
		homeObject= new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(jasonReader.firstname,jasonReader.lastname, jasonReader.email, jasonReader.password);

		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	//	registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.UserLogin(jasonReader.email, jasonReader.password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
	}	
}
