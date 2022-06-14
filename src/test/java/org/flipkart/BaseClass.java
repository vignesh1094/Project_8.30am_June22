package org.flipkart;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.collect.Multiset.Entry;

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
	//quit
	public static void quit() {
		driver.quit();

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
	
	static String ip;
	public static String iphones() {
		List<WebElement> iphones = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		System.out.println(iphones.size());
		
		for(WebElement x:iphones) {
			String name = x.getText();
			List<String> ip = new ArrayList<String>();
			ip.add(name);
			System.out.println(ip);
		}
		
		return ip;

	}
	
	static Integer li;
	public static Integer price() {
		
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		System.out.println(prices.size());
		
		for(WebElement p:prices) {
			String name=p.getText();
			
			if(name.contains("₹")) {
				name=name.replace("₹","");
				name=name.replace(",","");
			}
			int ps=Integer.parseInt(name);
			List<Integer> li=new ArrayList<Integer>();
			li.add(ps);
			
			System.out.println(li);
			
		}
		return li;
	}
	

	public static void map() {
		//iphone string
		List<WebElement> iphones = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		System.out.println(iphones.size());
		//iphone loop
		List<String> ip = new ArrayList<String>();
		for(WebElement x:iphones) {
			String name = x.getText();
			ip.add(name);
			}
		System.out.println(ip);
		
		//price integer
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		System.out.println(prices.size());
		//price loop
		List<Integer> li=new ArrayList<Integer>();
		for(WebElement p:prices) {
			String name=p.getText();
			
			if(name.contains("₹")) {
				name=name.replace("₹","");
				name=name.replace(",","");
				int ps=Integer.parseInt(name);
				li.add(ps);
			}	
		}
		System.out.println(li);
		
		Map<String,Integer> mp=new TreeMap<String,Integer>();
		for(int i=0;i<li.size();i++) {
			mp.put(ip.get(i), li.get(i));
		}
		System.out.println(mp);
		Set<java.util.Map.Entry<String,Integer>> es=mp.entrySet();
		for(java.util.Map.Entry<String,Integer> x:es) {	
			System.out.println(x);
		}
	}

	}
	


	
	
