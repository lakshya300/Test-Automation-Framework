package com.utility;

import java.awt.desktop.OpenFilesEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); //instance variable ->Heap Memory
	Logger logger = LoggerUtility.getLogger(this.getClass());

	
	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver); //initialize the instance variable!!
	}
	public BrowserUtility(String browserName) {
		logger.info("Launching Browser: "+browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			driver.set(new ChromeDriver());
		}
		
		else if (browserName.equalsIgnoreCase("edge")) {
			
			driver.set(new EdgeDriver());
		}
		else {

			logger.error("Invalid browser name");
			System.err.println("Invalid browser name");
		}
	}
	
	public BrowserUtility(Browser browserName) {
		logger.info("Launching Browser for: "+browserName);
		if(browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		}
		
		else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
		}
		else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}
		else {
			System.err.println("Invalid browser name");
		}
	}
	
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching Browser for: "+browserName);
		if(browserName == Browser.CHROME) {
			if(isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old"); //headless
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));	
			}
			else {
				driver.set(new ChromeDriver());		
			}
		}
		
		else if (browserName == Browser.EDGE) {
			if(isHeadless) {
				EdgeOptions options= new EdgeOptions();
				options.addArguments("--headless=old"); //headless
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));			
			}
			else {
				driver.set(new EdgeDriver());	
			}
		}
		else if (browserName == Browser.FIREFOX) {
			if(isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old"); //headless
				options.addArguments("disable-gpu");
				driver.set(new FirefoxDriver(options));			
			}
			else {
				driver.set(new FirefoxDriver());
			}
		}
		else {
			System.err.println("Invalid browser name");
		}
	}
	
	public void goToWebsite(String url)
	{
		logger.info("Visiting the website: "+url);
		driver.get().get(url);
	}
	
	public void maximizeWindow()
	{
		logger.info("Maximizing the browser window");

		driver.get().manage().window().maximize();	
	}
	
	public void clickOn(By locator) {
		logger.info("Finding element with the locator"+ locator);
		WebElement element =driver.get().findElement(locator); //Finds the element !!
		logger.info("Element Found and now performing click");
		element.click();
	}
	
	public void enterText(By locator, String textToEnter) {
		
		WebElement emailTextBoxWebElement = driver.get().findElement(locator);
		logger.info("Element found and now enter text:"+ textToEnter);
		emailTextBoxWebElement.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By locator) {
		logger.info("Finding element with the locator"+ locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now returning the visible text:"+ element.getText());
		return element.getText();
	}
	
	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
	    Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = "./screenshots/"+name+"- "+timeStamp+".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
