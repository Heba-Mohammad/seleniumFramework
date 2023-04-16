package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckOutPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import tests.TestBase;
import org.testng.Assert;

public class End2EndTests extends TestBase {
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage shoppingCartObject;
	CheckOutPage checkoutObject;
	OrderDetailsPage orderObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Given("user is on Home Page")
	public void user_is_on_home_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));
	}
	@When("he search for {string}")
	public void he_search_for(String productName) {
		searchObject =new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest(productName);
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);

	}
	@When("choose to buy two items")
	public void choose_to_buy_two_items() throws InterruptedException {
		detailsObject= new ProductDetailsPage(driver);
		detailsObject.AddToCart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com" +"/cart");
	}
	@When("moves to checkout cart and enter personal details on checkout page and place the order")
	public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() throws InterruptedException {
		shoppingCartObject=new ShoppingCartPage(driver);
		shoppingCartObject.openCheckoutPage();
		checkoutObject= new CheckOutPage(driver);
		checkoutObject.openCheckoutPageAsGuest();
		checkoutObject.CheckoutProductAsGuest("Heba","Mohamed","heba222@test.com","Bahrain", "mans", "mansoura", "12345", "123456789", productName);
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.successMessageLbl.isDisplayed());
	}
	@Then("he can view the order and dowload the invoice")
	public void he_can_view_the_order_and_dowload_the_invoice() throws InterruptedException {
		orderObject= new OrderDetailsPage(driver);
		checkoutObject.viewOrderDetails();
		orderObject.DownloadOrderDetails();
		Thread.sleep(3000);
		orderObject.PrintOrderDetails();

	}
}


