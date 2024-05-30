package com.qa.lnw.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import com.qa.lnw.Base.Base;
import com.qa.lnw.util.Utils;;

public class HomePage extends Base {

	private By searchField = By.id("twotabsearchtextbox");
	private By searchButton = By.id("nav-search-submit-button");
    private By amazonLogo = By.xpath("//div[@id='nav-logo']/a[@class='nav-logo-link nav-progressive-attribute']");

    public boolean validateLogo(){
		return driver.findElement(amazonLogo).isDisplayed();
	}

	public void enterSearchTerm(String searchTerm) {
		driver.findElement(searchField).sendKeys(searchTerm);
	}

	public void submitSearch() {
//		driver.findElement(searchButton).click();
		Utils.waitUntilClickable(driver, (driver.findElement(searchButton)));
		driver.findElement(searchButton).click();
		
	}
}
