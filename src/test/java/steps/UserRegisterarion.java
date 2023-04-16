package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import tests.TestBase;
import org.testng.Assert;

public class UserRegisterarion extends TestBase{

	HomePage homeObject ; 
	UserRegisterationPage registerObject ; 
	LoginPage LoginObject;

	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
		homeObject = new HomePage(driver); 
		homeObject.openRegisterationPage();

	}

	@When("I click on register link")
	public void i_click_on_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*	@When("I entered the user data")
	public void i_entered_the_user_data() {
		registerObject = new UserRegisterationPage(driver); 
		registerObject.userRegisteration("Moataz", "Nabil", "moataz15@test.com", "12345678");
	}*/

	/*@Then("The registeration page displayed successfully")
	public void the_registeration_page_displayed_successfully() {
		homeObject.openLoginPage();
		LoginObject= new LoginPage(driver);
		LoginObject.UserLogin("moataz15@test.com", "12345678");
		registerObject.userLogout(); 
	}*/
	@When("I entered {string},{string},{string},{string}")
	public void i_entered(String firstname, String lastname, String email, String password) {
		registerObject = new UserRegisterationPage(driver); 
		registerObject.userRegisteration(firstname, lastname,email ,password);
	}
	@Then("The registeration page displayed successfully {string},{string}")
	public void the_registeration_page_displayed_successfully(String email, String password) {
		homeObject.openLoginPage();
		LoginObject= new LoginPage(driver);
		LoginObject.UserLogin(email, password);
		registerObject.userLogout(); 
	}

}
