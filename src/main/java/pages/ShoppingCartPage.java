package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "button.remove-btn")
	WebElement removeBtn;
	
	@FindBy(id = "updatecart")
	WebElement updateTocartBtn;
	
	@FindBy(id = "itemquantity11252")
	 WebElement quantityTxt;
	
	@FindBy(css = "span.product-subtotal")
	public WebElement totalLbl;
	
	@FindBy(css = "div.no-data")
	public WebElement emptyCartLbl;

	@FindBy(id = "checkout")
	public WebElement checkoutBtn;
	
	@FindBy(id = "termsofservice")
	public WebElement agreeCheckbox;
	
	public void RemoveProductFromCart()
	{
		clickButton(removeBtn);
//		clickButton(updateTocartBtn);
	}
	
	public void UpdateProductQuantityIncart(String quantity)
	{
		//clear quantity textbox
		clearText(quantityTxt);
		setTextElementText(quantityTxt, quantity);
		clickButton(updateTocartBtn);
	}
	
	public void openCheckoutPage()
	{
		clickButton(agreeCheckbox);
		clickButton(checkoutBtn);
	}
	
	

}
