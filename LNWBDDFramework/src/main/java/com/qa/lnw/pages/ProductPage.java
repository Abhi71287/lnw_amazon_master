package com.qa.lnw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.lnw.Base.Base;
import com.qa.lnw.util.Utils;

public class ProductPage extends Base {

	private By monitorAddToCartButton = By.xpath("//input[@name='submit.add-to-cart']");
	private By laptopAddToCartButton = By.xpath("//input[@id='add-to-cart-button' and @type='submit']");
	private By headphoneProductPrice = By.xpath("//*[contains(@id,'corePrice_feature_div')]");
	private By productPrice = By.xpath("//span[@class='unified-price a-color-price']/p");
	private By label_scuccessmsg = By.xpath("//div[@id='attachDisplayAddBaseAlert']/div/h4");
	private By label_scuccessmsg2 = By.xpath("//h1[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']");
	private By closeCartDetails = By.xpath("//a[@id='attach-close_sideSheet-link']");
	private By btn_cart = By.xpath("//span[@id='nav-cart-count']");

	public void monitorAddToCart() {
		driver.findElement(monitorAddToCartButton).click();
	}

	public void laptopAddToCart() {
		Utils.scrollToElement(driver, (driver.findElement(laptopAddToCartButton)));
		driver.findElement(laptopAddToCartButton).click();
	}

	public String getProductPrice() {
		Utils.scrollToElement(driver, (driver.findElement(productPrice)));
		String price = driver.findElement(productPrice).getText();
		String cleaned = price.replaceAll("[^\\d,.]", "");
		return cleaned;
	}

	public String getHeadphoneProductPrice() {
		Utils.scrollToElement(driver, (driver.findElement(headphoneProductPrice)));
		String price = driver.findElement(headphoneProductPrice).getText();
		String cleaned = price.replaceAll("[^\\d,.]", "");
		cleaned.replace(",", "");
		cleaned = cleaned.substring(0, cleaned.length() - 2);
		Utils.addDecimalBeforeDoubleZero(cleaned);
		return cleaned;
	}

	public boolean verifyMonitorProductDetailPage() {
		Utils.scrollToElement(driver, (driver.findElement(monitorAddToCartButton)));
//		Utils.waitUntilClickable(driver, (driver.findElement(addToCartButton)));
		return driver.findElement(monitorAddToCartButton).isDisplayed();
	}

	public boolean verifyLaptopProductDetailPage() {
		Utils.scrollToElement(driver, (driver.findElement(laptopAddToCartButton)));
//		Utils.waitUntilClickable(driver, (driver.findElement(addToCartButton)));
		return driver.findElement(laptopAddToCartButton).isDisplayed();
	}

	public boolean verifyProductAdded() {

		boolean status = false;
		try {
			status = driver.findElement(label_scuccessmsg).isDisplayed();
		} catch (Exception e) {
			System.out.println("Entered Catch block");
			WebElement labael_successmsg_2 = driver.findElement(label_scuccessmsg);
			// status= labael_successmsg_2.isDisplayed();
			String actualMsg = labael_successmsg_2.getText();
			System.out.println("Text " + actualMsg);
			if (actualMsg.equalsIgnoreCase("Added to Cart")) {
				status = true;
			}
		}

		return status;
	}
	
	public boolean verifyBothOfTheProductAdded() {

		boolean status = false;
		try {
			status = driver.findElement(label_scuccessmsg2).isDisplayed();
		} catch (Exception e) {
			System.out.println("Entered Catch block");
			WebElement labael_successmsg_2 = driver.findElement(label_scuccessmsg2);
			// status= labael_successmsg_2.isDisplayed();
			String actualMsg = labael_successmsg_2.getText();
			System.out.println("Text " + actualMsg);
			if (actualMsg.equalsIgnoreCase("Added to Cart")) {
				status = true;
			}
		}

		return status;
	}

	public void closeCartDetails() {
		driver.findElement(closeCartDetails).click();
	}

	public void proccedtoCart() {
		Utils.waitUntilClickable(driver, (driver.findElement(btn_cart)));
		Utils.scrollToElement(driver, (driver.findElement(btn_cart)));
		driver.findElement(btn_cart).click();
	}

}
