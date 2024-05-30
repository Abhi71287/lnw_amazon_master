package com.qa.lnw.pages;

import org.openqa.selenium.By;

import com.qa.lnw.Base.Base;
import com.qa.lnw.util.Utils;

public class CartPage extends Base {

	private By cartSubtotal = By.id("sc-subtotal-amount-activecart");
	private By productPrice = By.xpath("//span[contains(@class, 'product-price a-text-bold')]");
	private By searchField = By.id("twotabsearchtextbox");
	private By searchButton = By.id("nav-search-submit-button");
	private By headphoneProductPrice = By.xpath(
			"(//div[@data-name='Active Items']//div/span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[2]");
	private By keyBoardProductPrice = By.xpath(
			"(//div[@data-name='Active Items']//div/span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[1]");

	public void enterSearchTerm(String searchTerm) {
		Utils.scrollToElement(driver, driver.findElement(searchField));
		driver.findElement(searchField).clear();
		driver.findElement(searchField).sendKeys(searchTerm);
	}

	public void submitSearch() {
		Utils.waitUntilClickable(driver, (driver.findElement(searchButton)));
		driver.findElement(searchButton).click();

	}

	public boolean verifyCratPage() {
		String expectedUrl = "https://www.amazon.in/gp/cart/view.html?ref_=nav_cart";
		String actualUrl = driver.getCurrentUrl();
		if (actualUrl.equals(expectedUrl)) {
			return true;
		}
		return false;
	}

	public String getCartSubtotal() {
		String price = driver.findElement(cartSubtotal).getText();
		String cleaned = price.replaceAll("[^\\d,.]", "");
		return cleaned;
	}

	public double getBothItemsSubtotal() {
		String price1 = getHeadphoneProductPriceOnCartPage();
		String price2 = getKeyBoardProductPriceOnCartPage();

		// Convert prices to numerical values
		double item1Price = convertPriceToDouble(price1);
		double item2Price = convertPriceToDouble(price2);
		// Calculate the sum of prices
		double expectedTotalPrice = item1Price + item2Price;
		
		return expectedTotalPrice;

	}
	
	public double getBothItemCartSubtotal() {
		String subtotal = driver.findElement(cartSubtotal).getText();
		String cleaned = subtotal.replaceAll("[^\\d,.]", "");
		cleaned.replace(",", "");
		cleaned = cleaned.substring(0, cleaned.length() - 2);
		Utils.addDecimalBeforeDoubleZero(cleaned);
		double actualTotalPrice = convertPriceToDouble(cleaned);
		return actualTotalPrice;
	}

	private double convertPriceToDouble(String price) {
		String cleanedPrice = price.replaceAll("[^\\d.]", "");
		return Double.parseDouble(cleanedPrice);
	}

	public String getProductPriceOnCartPage() {
		Utils.scrollToElement(driver, (driver.findElement(productPrice)));
		String price = driver.findElement(productPrice).getText();
		String cleaned = price.replaceAll("[^\\d,.]", "");
		return cleaned;
	}

	public String getHeadphoneProductPriceOnCartPage() {
		Utils.scrollToElement(driver, (driver.findElement(headphoneProductPrice)));
		String price = driver.findElement(headphoneProductPrice).getText();
		System.out.println(price);
		String cleaned = price.replaceAll("[\\s,.]+", "");
		cleaned = cleaned.substring(0, cleaned.length() - 2);
		return cleaned;
	}

	public String getKeyBoardProductPriceOnCartPage() {
		Utils.scrollToElement(driver, (driver.findElement(keyBoardProductPrice)));
		String price = driver.findElement(keyBoardProductPrice).getText();
		System.out.println(price);
		String cleaned = price.replaceAll("[\\s,.]+", "");
		cleaned = cleaned.substring(0, cleaned.length() - 2);
		return cleaned;
	}
}
