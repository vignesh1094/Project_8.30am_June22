package org.flipkart;


import java.awt.AWTException;
import java.util.Collections;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


public class TestNgCall extends BaseClass {
	

	
	@Test
	private void laptopsearch() throws AWTException, InterruptedException {
		
		browserLaunch("chrome");
		urlLaunch("https://www.flipkart.com/");
		Locators f=new Locators();
		click(f.getClose());
		sendKeys(f.getSearch(), "laptop");
		pressEnter();
		wait(3000);

		}

}
