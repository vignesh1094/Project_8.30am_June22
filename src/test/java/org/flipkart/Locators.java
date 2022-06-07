package org.flipkart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Locators extends BaseClass {
	public Locators() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='✕']")
	private WebElement Close;

	public WebElement getClose() {
		return Close;
	}
	
	@FindBy(name="q")
	private WebElement search;

	public WebElement getSearch() {
		return search;
	}
	
	@FindBy(xpath="//div[text()='APPLE iPhone 13 (Pink, 128 GB)']")
	private WebElement iphone;

	public WebElement getIphone() {
		return iphone;
	}
	
	
	
}

	
