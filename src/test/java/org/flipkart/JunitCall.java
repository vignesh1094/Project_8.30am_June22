package org.flipkart;

import java.awt.AWTException;


public class JunitCall extends BaseClass {
	
	public static void main(String[] args) throws AWTException {
		browserLaunch("chrome");
		urlLaunch("https://www.flipkart.com/");
		
		Locators f=new Locators();
		click(f.getClose());
		
		sendKeys(f.getSearch(), "oneplus");
		robotE();
	}

}
