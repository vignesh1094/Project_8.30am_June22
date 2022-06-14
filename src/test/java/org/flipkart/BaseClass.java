package org.flipkart;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
	public static void pressEnter() throws AWTException{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	public static void scroll(WebElement webElement) {
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView(true)", webElement);
	}
	
	public static void iphone() {
		
		List<WebElement> iphones = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		System.out.println(iphones.size());
		
		for(WebElement x:iphones) {
			String name = x.getText();
			System.out.println(name);
		}
		
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		System.out.println(prices.size());
		
		for(WebElement x:prices) {
			String name = x.getText();
			System.out.println(name);
		}
		
		
		
		

	}
	public static void price() {
		List<WebElement> iphones = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		System.out.println(iphones.size());
		WebElement webElement = iphones.get(3);
		System.out.println(webElement);
		
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		System.out.println(prices.size());

		for(int i=0;i<iphones.size();i++) {
			System.out.println(iphones.get(i)+"==="+prices.get(i));
			
		}
		Map<String, String> mp=new LinkedHashMap<String, String>();
		for (int i = 0; i < iphones.size(); i++) {
			mp.put(iphones.get(i), prices.get(i));
		}
	

	}
	
	
	

}
