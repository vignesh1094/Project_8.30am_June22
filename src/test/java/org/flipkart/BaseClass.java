package org.flipkart;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	//browser
	public static WebDriver browserLaunch(String bname ) {
					
		if(bname.equalsIgnoreCase("chrome")) {	
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
		else if(bname.equalsIgnoreCase("firefox")) {	
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			}
		else if(bname.equalsIgnoreCase("edge")) {	
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			}
	return driver;
	}
	//url
	public static void urlLaunch(String url) {
		driver.get(url);
	}
	//click
	public static void click(WebElement e) {
		e.click();
	}
	
	//sendkeys
	public static void sendKeys(WebElement e,String value) {
		e.sendKeys(value);
	}
	//windows handleing
	public static void windows(int i) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> li=new LinkedList<String>();
		li.addAll(windowHandles);
		
		driver.switchTo().window(li.get(i));
	}
	
	//absolutewait
	public static void wait(int w) throws InterruptedException {
		Thread.sleep(w);
	}
	
	//enter
	public static void robotE() throws AWTException{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	public static void scroll(WebElement webElement) {
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView(true)", webElement);
	}

}
