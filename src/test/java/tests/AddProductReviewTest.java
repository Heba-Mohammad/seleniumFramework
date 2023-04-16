package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class AddProductReviewTest extends TestBase
{
	//5- logout

	//1-user registration
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ProductReviewPage reviewObject;

	@Test(priority = 1 , alwaysRun = true)
	public void UserCanRegisterSuccssfully()
	{
		homeObject= new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration("Heba", "Mohamed", "testtest12@gmail.com", "123456789");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	//2- user login
	@Test (priority = 2)
	public void RegisteredUserCanLogin()
	{
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.UserLogin("testtest12@gmail.com", "123456789");
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

	//4- add review
	@Test(priority = 4)
	public void registeredUserCanReviewProduct()
	{
		detailsObject.openAddReviewPage();
		reviewObject= new ProductReviewPage(driver);
		reviewObject.addProductReview("new review", "product is good");
		Assert.assertTrue(reviewObject.reviewNotification.getText().contains("Product review is successfully added."));
	}
	
	//5- user logout
	@Test(priority = 5)
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();

	}


}
