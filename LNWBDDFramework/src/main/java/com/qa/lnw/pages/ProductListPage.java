package com.qa.lnw.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.lnw.Base.Base;
import com.qa.lnw.util.Utils;

public class ProductListPage extends Base {

	private By Product = By.xpath("//*[@id='search']/span[2]");

	private By firstProductLink = By
			.xpath("//img[@data-image-index='3']//parent::div[@class='a-section aok-relative s-image-fixed-height']");
	private By secondProductLink = By
			.xpath("//img[@data-image-index='1']//parent::div[@class='a-section aok-relative s-image-fixed-height']");

	public boolean verifyListOfItems() {
		Utils.waitUntilClickable(driver, (driver.findElement(Product)));
		return (driver.findElement(Product)).isDisplayed();
	}

	public void selectFirstProduct() {
		Utils.scrollToElement(driver, (driver.findElement(firstProductLink)));
		 String originalWindow = driver.getWindowHandle();
		(driver.findElement(firstProductLink)).click();
		 Set<String> allWindows = driver.getWindowHandles();
	        for (String windowHandle : allWindows) {
	            if (!windowHandle.equals(originalWindow)) {
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }
	}
	
	public void selectSecondProduct() {
		Utils.scrollToElement(driver, (driver.findElement(secondProductLink)));
		 String originalWindow = driver.getWindowHandle();
		(driver.findElement(secondProductLink)).click();
		 Set<String> allWindows = driver.getWindowHandles();
	        for (String windowHandle : allWindows) {
	            if (!windowHandle.equals(originalWindow)) {
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }
	}
	
	public void selectAnotherProductOnSameSession() {
		Utils.scrollToElement(driver, (driver.findElement(firstProductLink)));
        String currentWindow = driver.getWindowHandle();
        Set<String> windowHandlesBeforeClick = driver.getWindowHandles();
        (driver.findElement(firstProductLink)).click();
        Set<String> windowHandlesAfterClick = driver.getWindowHandles();
        for (String windowHandle : windowHandlesAfterClick) {
            if (!windowHandlesBeforeClick.contains(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
	
	

}
