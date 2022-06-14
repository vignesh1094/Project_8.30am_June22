package org.flipkart;

import java.awt.AWTException;
import java.util.Collections;

import org.openqa.selenium.Keys;


public class JunitCall extends BaseClass {
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		browserLaunch("chrome");
		urlLaunch("https://www.flipkart.com/");
		Locators f=new Locators();
		click(f.getClose());
		sendKeys(f.getSearch(), "iphone");
		pressEnter();
		wait(3000);
		iphones();
		price();
		map();
//		quit();
		
		}

}
