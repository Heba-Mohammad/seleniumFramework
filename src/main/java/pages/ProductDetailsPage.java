package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css = "strong.current-item")
	public WebElement productNamebreadCrumb;
	
	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement emailFriendBtn;
	
	@FindBy(id = "price-value-4")
	public WebElement productPriceLbl;
	
	@FindBy(linkText = "Add your review")
	public WebElement addYourReviewLink;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addToWishListBtn;
	
	@FindBy(linkText = "wishlist")
	WebElement wishlistLink;
	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn;
	
	@FindBy(id = "add-to-cart-button-4")
	WebElement addToCartBtn;
	
	public void openSendEmailFriend()
	{
		clickButton(emailFriendBtn);
	}
	
	public void openAddReviewPage()
	{
		clickButton(addYourReviewLink);
	}

	public void addProductToWishList()
	{
		clickButton(addToWishListBtn);
	}
	public void navigateToWishListPage() 
	{
		clickButton(wishlistLink);
	}
	
	public void addProductTocompare()
	{
		clickButton(addToCompareBtn);
	}
	
	public void AddToCart()
	{
		clickButton(addToCartBtn);
	}
}
