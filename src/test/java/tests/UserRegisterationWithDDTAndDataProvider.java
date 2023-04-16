package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndDataProvider extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;

	@DataProvider(name = "testData")
	public static Object[][] userData()
	{
		return new Object[][]
		{
			{"Heba","Mohamed","test15@gmail.com","123456"}
			,{"Ahmed","ali","testali15@gmail.com","12345678"}
		};
	}


	@Test(priority = 1,dataProvider = "testData" , alwaysRun = true)
	public void UserCanRegisterSuccssfully(String fname,String lname,String email, String password)
	{
		homeObject= new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(fname, lname, email, password);

		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));		
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.UserLogin(email, password);
		
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
		
	}

}
