package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);	
		jse= (JavascriptExecutor)driver;
		action= new Actions(driver);
	}

	@FindBy(linkText = "Register")
	WebElement registerLink;
	
	@FindBy(linkText = "Log in")
	WebElement loginLink;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;
	
	@FindBy(id = "customerCurrency")
	WebElement currencyDropDwonList;
	
	@FindBy(linkText = "Computers ")
	WebElement computerMenu;
	
	@FindBy(linkText ="Notebooks ")
	WebElement notebookMenu;
	
	public void openRegisterationPage()
	{
	//	registerLink.click();
		clickButton(registerLink);
	}
	
	public void openLoginPage()
	{
		clickButton(loginLink);
	}
	//its implementation is in page base
	public void openContactUsPage()
	{
		scrollToButtom();
		clickButton(contactUsLink);
	}
	
	public void changeCurrency()
	{
		select = new Select(currencyDropDwonList);
		select.selectByVisibleText("Euro");
	}
	
	public void selectNotebooksMenu()
	{
		action.moveToElement(computerMenu)
		.moveToElement(notebookMenu)
		.click()
		.build()
		.perform();
	}
}


