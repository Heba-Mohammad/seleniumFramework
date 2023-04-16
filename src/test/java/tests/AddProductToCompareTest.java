package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase{
	
	String  firstProductName="Apple MacBook Pro 13-inch";
	String secondProductName="Asus N551JK-XO076H Laptop";
	//1-search for product no1
	//2- search for product no 2
	//3- add to compare
	//4- clear compare list
	
	ProductDetailsPage detailsObject;
	HomePage homeObject;
	ComparePage compareObject;
	SearchPage searchObject;
	
	@Test(priority = 1)
	public void UserCanCompareProduct() throws InterruptedException
	{
		searchObject=  new SearchPage(driver);
		detailsObject=new ProductDetailsPage(driver);
		compareObject= new ComparePage(driver);
		
		searchObject.ProductSearchUsingAutoSuggest(""
				+ "MacB");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(firstProductName));
		detailsObject.addProductTocompare();
		
		searchObject.ProductSearchUsingAutoSuggest("Asus");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(secondProductName));
		detailsObject.addProductTocompare();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com" + "/compareproducts");
		Assert.assertTrue(compareObject.firstProductName.getText().equals("Apple MacBook Pro 13-inch"));
		Assert.assertTrue(compareObject.secondProductName.getText().equals("Asus N551JK-XO076H Laptop"));
		compareObject.compareProducts();	
	}
	
	@Test(priority = 2)
	public void UserCanClearCompareList()
	{
		compareObject.clearCompareList();
		Assert.assertTrue(compareObject.noDataLbl.getText().contains("You have no items to compare."));
	}

}
