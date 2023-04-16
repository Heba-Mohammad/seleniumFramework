package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUstest extends TestBase{
	
	HomePage home;
	ContactUsPage contactPage;
	String email="heba22@test.com";
	String fullName="Heba Mohamed";
	String enquiry="hello there iam here...";
	@Test
	public void userCanContactUs()
	{
		home= new HomePage(driver);
		home.openContactUsPage();
		contactPage = new ContactUsPage(driver);
		contactPage.contactUs(fullName, email, enquiry);
		Assert.assertTrue(contactPage.successMessage.getText()
				.contains("Your enquiry has been successfully sent to the store owner."));
	}

}
