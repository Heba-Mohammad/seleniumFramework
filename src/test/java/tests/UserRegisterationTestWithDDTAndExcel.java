package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithDDTAndExcel extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	@DataProvider (name="ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		//get data from excel reader class
		ExcelReader ER= new ExcelReader();
		return ER.getExcelData();
	}
	
	@Test(priority = 1 , alwaysRun = true,dataProvider = "ExcelData")
	public void UserCanRegisterSuccssfully(String firstname,String lastname,String email,String password)
	{
		homeObject= new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(firstname,lastname,email,password);		
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.UserLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
		
	}

}
