package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegisterationPage;

public class GuestCheckoutProductFromCart extends TestBase{

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ProductReviewPage reviewObject;
	ShoppingCartPage shoppingCartObject;
	CheckOutPage checkoutObject;
	OrderDetailsPage orderObject;

	@Test(priority = 1)
	public void UserCanSearchWithAutoSuggest()
	{
		searchObject =new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
	}
	//4- add to cart
	@Test(priority = 2)
	public void UserAddProductToShoppingcart() throws InterruptedException
	{
		detailsObject= new ProductDetailsPage(driver);
		detailsObject.AddToCart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com" +"/cart");
		shoppingCartObject=new ShoppingCartPage(driver);
		Assert.assertTrue(shoppingCartObject.totalLbl.getText().contains("3,600"));
	}

	//5- checkout
	@Test(priority = 3)
	public void UserCanCheckout() throws InterruptedException
	{
		shoppingCartObject=new ShoppingCartPage(driver);
		shoppingCartObject.openCheckoutPage();
		checkoutObject= new CheckOutPage(driver);
		checkoutObject.openCheckoutPageAsGuest();
		checkoutObject.CheckoutProductAsGuest("Heba","Mohamed","heba222@test.com","Bahrain", "mans", "mansoura", "12345", "123456789", productName);
		Assert.assertTrue(checkoutObject.productNameLbl.isDisplayed());
		Assert.assertTrue(checkoutObject.productNameLbl.getText().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.successMessageLbl.isDisplayed());
	}

	@Test(priority = 4)
	public void UserCanViewOrderDetails() throws InterruptedException 
	{
		checkoutObject = new CheckOutPage(driver);
		checkoutObject.viewOrderDetails();
		//	Assert.assertTrue(checkoutObject.orderDetailsLink.getText().contains("Click here for order details."));
		//	Assert.assertTrue(driver.getCurrentUrl().contains("Click here for order details."));
		orderObject= new OrderDetailsPage(driver);
		orderObject.DownloadOrderDetails();
		Thread.sleep(3000);		
		orderObject.PrintOrderDetails();
	}
}
