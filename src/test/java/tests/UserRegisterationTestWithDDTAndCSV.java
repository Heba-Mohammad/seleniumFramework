package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithDDTAndCSV extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;

	CSVReader reader ;

	@Test(priority = 1 , alwaysRun = true)
	public void UserCanRegisterSuccssfully() throws CsvValidationException, IOException
	{
		//get path of CSV file
		String CSV_file= System.getProperty("user.dir")+"\\src\\test\\java\\data\\userdatacsv.csv";
		reader= new CSVReader(new FileReader(CSV_file));
		String[] csvCell;
		//while loop will be executed till the last value in csv file
		while((csvCell = reader.readNext())!=null)
		{
			String firstname= csvCell[0];
			String lastname= csvCell[1];
			String email= csvCell[2];
			String password= csvCell[3];
			homeObject= new HomePage(driver);
			homeObject.openRegisterationPage();
			registerObject = new UserRegisterationPage(driver);
			registerObject.userRegisteration(firstname, lastname, email,password);

			Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
			homeObject.openLoginPage();
			loginObject= new LoginPage(driver);
			loginObject.UserLogin(email, password);
			Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
			registerObject.userLogout();	
		}		

	}

}
