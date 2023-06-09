package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithJavaFaker extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	Faker fakeData= new Faker();
	String firstname= fakeData.name().firstName();
	String lastname= fakeData.name().lastName();
	String email= fakeData.internet().emailAddress();
	String password= fakeData.number().digits(8).toString();

	@Test(priority = 1 , alwaysRun = true)
	public void UserCanRegisterSuccssfully()
	{
		homeObject= new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(firstname, lastname, email, password);

		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.UserLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		System.out.println("the user data are: "+firstname + " "+ lastname + " "+ email + " " + password);
		registerObject.userLogout();

	}
}
