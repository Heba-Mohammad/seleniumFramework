package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase{

	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage shoppingCartObject;
	String productName="Apple MacBook Pro 13-inch";

	@Test(priority = 1)
	public void UserCanFindProductWithAutoSuggest()
	{
		searchObject =new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
	}
	
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
	
	@Test(priority = 3)
	public void UserCanRemoveProductFromCart() throws InterruptedException
	{
		shoppingCartObject= new ShoppingCartPage(driver);
		Thread.sleep(2000);
		shoppingCartObject.RemoveProductFromCart();
		Assert.assertTrue(shoppingCartObject.emptyCartLbl.getText().contains("Your Shopping Cart is empty!"));
	}


}
