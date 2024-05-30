package com.qa.lnw.stepDefination;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.qa.lnw.Base.Base;
import com.qa.lnw.pages.CartPage;
import com.qa.lnw.pages.HomePage;
import com.qa.lnw.pages.ProductListPage;
import com.qa.lnw.pages.ProductPage;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Scenario_1_Steps extends Base {

	private HomePage homePage;
	private ProductListPage productListPage;
	private ProductPage productPage;
	private CartPage cartPage;
	private String productPrice;
	private String headphoneProductPrice;
	private String keyBoardProductPrice;

	public Scenario_1_Steps() {
		super();
		initilization();
		homePage = new HomePage();
		productListPage = new ProductListPage();
		cartPage = new CartPage();
		productPage = new ProductPage();
	}

	@Given("I am on the Amazon.com homepage")
	public void iAmOnTheAmazonComHomepage() {
		boolean flag = homePage.validateLogo();
		Assert.assertTrue(flag);
	}

	@When("I type {string} in the search field")
	public void iTypeInTheSearchField(String searchTerm) {
		homePage.enterSearchTerm(searchTerm);
	}
	
	@When("I enter {string} in the search field")
	public void i_enter_in_the_search_field(String string) {
	   cartPage.enterSearchTerm(string);
	}

	@And("I click on search button")
	public void iPressEnter() {
		homePage.submitSearch();
	}

	@Then("I should see a list of monitors displayed")
	public void iShouldSeeAListOfMonitorsDisplayed() {
		boolean flag = productListPage.verifyListOfItems();
		Assert.assertTrue(flag);
	}

	@Then("I should see a list of headphones displayed")
	public void i_should_see_a_list_of_headphones_displayed() {
		boolean flag = productListPage.verifyListOfItems();
		Assert.assertTrue(flag);
	}

	@When("I select the first item in the list")
	public void iSelectTheFirstItemInTheList() {
		productListPage.selectFirstProduct();
	}

	@When("I select the second item in the list")
	public void i_select_the_second_item_in_the_list() {
		productListPage.selectSecondProduct();
	}

	@Then("I should be on the monitor product page")
	public void iShouldBeOnMonitorProductPage() {
		boolean flag = productPage.verifyMonitorProductDetailPage();
		Assert.assertTrue(flag);
	}

	@Then("I should be on the laptop product page")
	public void iShouldBeOnLaptopProductPage() {
		boolean flag = productPage.verifyLaptopProductDetailPage();
		Assert.assertTrue(flag);
	}

	@Then("I should be on the product page for the first item")
	public void i_should_be_on_the_product_page_for_the_first_item() {
		boolean flag = productPage.verifyMonitorProductDetailPage();
		Assert.assertTrue(flag);
	}

	@When("I add the montior item to the cart by clicking on Add to Cart Button")
	public void monitorItemToTheCartByClickingOnAddToCart() {
		productPrice = productPage.getProductPrice();
		System.out.println(productPrice);
		productPage.monitorAddToCart();
	}

	@When("I add the laptop item to the cart by clicking on Add to Cart Button")
	public void laptopItemToTheCartByClickingOnAddToCart() {
		productPrice = productPage.getProductPrice();
		System.out.println(productPrice);
		productPage.laptopAddToCart();
	}

	@Then("I should see a success message confirming the item is added to the cart")
	public void iShouldSeeASuccessMessageConfirmingTheItemIsAddedToTheCart() {
		productPage.verifyProductAdded();
		productPage.closeCartDetails();
	}

	@When("I open the cart from the top-left corner")
	public void iOpenTheCartFromTheTopLeftCorner() {
		productPage.proccedtoCart();
	}

	@Then("I should be on the cart page")
	public void iShouldBeOnTheCartPage() {
		boolean flag = cartPage.verifyCratPage();
		Assert.assertTrue(flag);
	}

	@And("the price on the cart page should match the price on the product page")
	public void thePriceOnTheCartPageShouldMatchThePriceOnTheProductPage() {
		String productPriceOnCartPage = cartPage.getProductPriceOnCartPage();
		System.out.println(productPriceOnCartPage);
		assert productPriceOnCartPage.equals(productPrice) : "Cart Product Price does not match with product price";

	}

	@Then("the subtotal on the cart page should match the total on the product page")
	public void the_subtotal_on_the_cart_page_should_match_the_total_on_the_product_page() {
		String cartSubtotal = cartPage.getCartSubtotal();
		assert cartSubtotal.equals(productPrice) : "Subtotal does not match product price";
	}

	@Then("I note the product price for the first item")
	public void i_note_the_product_price_for_the_first_item() {
		headphoneProductPrice = productPage.getHeadphoneProductPrice();
		System.out.println(headphoneProductPrice);

	}
	
	@Then("I should see a success message confirming the both the items are added to the cart")
	public void i_should_see_a_success_message_confirming_the_both_the_items_are_added_to_the_cart() {
		productPage.verifyProductAdded();
		productPage.closeCartDetails();
		productPage.proccedtoCart();
}

	@When("I add the Headphone item to the cart by clicking on Add to Cart Button")
	public void i_add_the_headphone_item_to_the_cart_by_clicking_on_add_to_cart_button() {
		productPage.monitorAddToCart();
	}

	@Then("I should see a list of keyboards displayed")
	public void i_should_see_a_list_of_keyboards_displayed() {
		boolean flag = productListPage.verifyListOfItems();
		Assert.assertTrue(flag);
	}

	@Then("I should be on the product page for the second item")
	public void i_should_be_on_the_product_page_for_the_second_item() {
		boolean flag =productPage.verifyMonitorProductDetailPage();
		Assert.assertTrue(flag);
	}

	@Then("I note the product price for the second item")
	public void i_note_the_product_price_for_the_second_item() {
		keyBoardProductPrice=productPage.getHeadphoneProductPrice();
		System.out.println(keyBoardProductPrice);
	}
	
	@When("I add the KeyBoard item to the cart by clicking on Add to Cart Button")
	public void i_add_the_key_board_item_to_the_cart_by_clicking_on_add_to_cart_button() {
	   productPage.monitorAddToCart();
	}
	
	@When("I select the first item from the  list")
	public void i_select_the_first_item_from_the_list() {
		productListPage.selectAnotherProductOnSameSession();
	}

	@Then("the price of the first item in the cart should match the price on the product page")
	public void the_price_of_the_first_item_in_the_cart_should_match_the_price_on_the_product_page() {
		String productPriceOnCartPage = cartPage.getKeyBoardProductPriceOnCartPage();
		System.out.println(productPriceOnCartPage);
		assert productPriceOnCartPage.equals(keyBoardProductPrice) : "Cart Product Price does not match with product price";
	}

	@Then("the price of the second item in the cart should match the price on the product page")
	public void the_price_of_the_second_item_in_the_cart_should_match_the_price_on_the_product_page() {
		String productPriceOnCartPage = cartPage.getHeadphoneProductPriceOnCartPage();
		System.out.println(productPriceOnCartPage);
		assert productPriceOnCartPage.equals(headphoneProductPrice) : "Cart Product Price does not match with product price";
	}

	@Then("the subtotal on the cart page should be the sum of the prices of the two items")
	public void the_subtotal_on_the_cart_page_should_be_the_sum_of_the_prices_of_the_two_items() {
		double expectedTotalPrice = cartPage.getBothItemCartSubtotal();
		double actualTotalPrice   = cartPage.getBothItemsSubtotal();
		 Assert.assertEquals(expectedTotalPrice, actualTotalPrice, "Subtotal does not match the sum of item prices");
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}