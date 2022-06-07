package org.flipkart;

import org.openqa.selenium.WebElement;
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
	
	@FindBy(xpath="//div[text()='OnePlus Y1 80 cm (32 inch) HD Ready LED Smart Android TV']")
	private WebElement tv;

	public WebElement getTv() {
		return tv;
	}
	
	@FindBy(xpath="//button[text()='ADD TO CART']")
	private WebElement cart;

	public WebElement getCart() {
		return cart;
	}
	
	
	@FindBy(id="pincodeInputId")
	private WebElement pincode;

	public WebElement getPincode() {
		return pincode;
	}
	
	@FindBy(xpath="//span[text()='Check']")
	private WebElement pinCheck;

	public WebElement getPinCheck() {
		return pinCheck;
	}
	
	@FindBy(xpath="//span[text()='Visit the']//following::a[text()='Help Center']")
	private WebElement helpCenter;

	public WebElement getHelpCenter() {
		return helpCenter;
	}
	
	@FindBy(xpath="//span[text()='View More']")
	private WebElement more;

	public WebElement getMore() {
		return more;
	}

}
