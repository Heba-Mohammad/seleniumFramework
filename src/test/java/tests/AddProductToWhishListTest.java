package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWhishListTest extends TestBase{
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishListPage wishListObject;
	
	@Test(priority = 1)
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
	@Test(priority = 2)
	public void UsercanAddProductTpWishList()
	{
		detailsObject= new ProductDetailsPage(driver);
		detailsObject.addProductToWishList();
	//	driver.navigate().to("https://demo.nopcommerce.com/wishlist");
		detailsObject.navigateToWishListPage();
		wishListObject=new WishListPage(driver);
		Assert.assertTrue(wishListObject.wishlistHeader.isDisplayed());
		Assert.assertTrue(wishListObject.productCell.getText().contains(productName));
	}
	
	@Test(priority =3)
	public void UserCanRemoveProductFromCart()
	{		
		wishListObject= new WishListPage(driver);
		wishListObject.removeProductFromWishlist();
		Assert.assertTrue(wishListObject.emptyCartLbl.getText().contains("The wishlist is empty!"));
	}
}
