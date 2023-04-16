package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;



public class CheckOutPage extends PageBase{

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "button.button-1.checkout-as-guest-button")
	WebElement guestBtn;

	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement fnTxt;

	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lsTxt;

	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailTxt;

	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryList;

	@FindBy(id = "BillingNewAddress_City")
	WebElement cityTxt;

	@FindBy(id = "BillingNewAddress_Address1")
	WebElement adressTxt;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement postalCodeTxt;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneTxt;

	@FindBy(css = "button.button-1.new-address-next-step-button")
	WebElement continueBtn;

	@FindBy(id = "shippingoption_0")
	WebElement ShippingMethodRdo;

	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	WebElement continueShipingBtn;

	@FindBy(id = "paymentmethod_0")
	WebElement paymentMethodCheck;

	@FindBy(css = "button.button-1.payment-method-next-step-button")
	WebElement continuePaymentBtn;

	@FindBy(css = "button.button-1.payment-info-next-step-button")
	WebElement continueInfoBtn;

	@FindBy(css = "a.product-name")
	public WebElement productNameLbl;

	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement continueConfirmBtn;

	@FindBy(css = "div.page-title")
	public WebElement thankYouLbl;

	@FindBy(css = "div.title")
	public WebElement successMessageLbl;

	@FindBy(linkText = "Click here for order details.")
	public WebElement orderDetailsLink;

	@FindBy(css = "button.button-1.order-completed-continue-button")
	WebElement continueCompleteBtn;
	
	
	
	

	public void RegisteredUserCheckoutProduct(String countryName, String city,String adress,String postalCode,String phoneNo,String productName) throws InterruptedException 
	{
		select= new Select(countryList);
		select.selectByVisibleText(countryName);
		setTextElementText(cityTxt, city);
		setTextElementText(adressTxt, adress);
		setTextElementText(postalCodeTxt, postalCode);
		setTextElementText(phoneTxt, phoneNo);
		clickButton(continueBtn);
		clickButton(ShippingMethodRdo);
		clickButton(continueShipingBtn);
		Thread.sleep(1000);
		clickButton(paymentMethodCheck);
		clickButton(continuePaymentBtn);
		clickButton(continueInfoBtn);		
	}

	public void confirmOrder() throws InterruptedException
	{
		Thread.sleep(1000);
		clickButton(continueConfirmBtn);
	//	clickButton(continueCompleteBtn);
	}	
	
	public void viewOrderDetails() throws InterruptedException
	{
		clickButton(orderDetailsLink);
	}
	
	public void openCheckoutPageAsGuest()
	{
		clickButton(guestBtn);
	}
	
	public void CheckoutProductAsGuest(String firstName,String lastName,String email,String countryName, String city,
			                           String adress,String postalCode,String phoneNo,String productName) throws InterruptedException 
	{
		setTextElementText(fnTxt, firstName);
		setTextElementText(lsTxt, lastName);
		setTextElementText(emailTxt,email );
		select= new Select(countryList);
		select.selectByVisibleText(countryName);
		setTextElementText(cityTxt, city);
		setTextElementText(adressTxt, adress);
		setTextElementText(postalCodeTxt, postalCode);
		setTextElementText(phoneTxt, phoneNo);
		clickButton(continueBtn);
		clickButton(ShippingMethodRdo);
		clickButton(continueShipingBtn);
		Thread.sleep(2000);
		clickButton(paymentMethodCheck);
		clickButton(continuePaymentBtn);
		Thread.sleep(2000);
		clickButton(continueInfoBtn);
	}
}
