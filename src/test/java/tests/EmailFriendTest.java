package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailFriendTest extends TestBase
{
	//1-user registration
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage emailObject;

	@Test(priority = 1 , alwaysRun = true)
	public void UserCanRegisterSuccssfully()
	{
		homeObject= new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration("Heba", "Mohamed", "test137@gmail.com", "123456789");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	//2- user login
	@Test (priority = 2)
	public void RegisteredUserCanLogin()
	{
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.UserLogin("test137@gmail.com", "123456789");
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}

	//3- search for product	
	@Test(priority = 3)
	public void UserCanSearchWithAutoSuggest()
	{
		try {
			searchObject =new SearchPage(driver);
			searchObject.ProductSearchUsingAutoSuggest("MacB");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
		} catch (Exception e) {
			System.out.println("Error occurred  "+ e.getMessage());
		}
	}

	//4- Email to friend
	@Test(priority = 4)
	public void registeredUserCanSendProductToFriend()
	{
		detailsObject.openSendEmailFriend();
		emailObject = new EmailPage(driver);
		emailObject.sendEmailToFriend("ahm@test.com", "hello friend");
		Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message has been sent."));
	}

	//5- user logout
	@Test(priority = 5)
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();

	}

}
