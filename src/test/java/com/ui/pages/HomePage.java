package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;

import java.sql.Driver;

import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;


public final class HomePage extends BrowserUtility{
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName,isHeadless); //call the parent class constructor from the child class constructor
		maximizeWindow();
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}
	
	public HomePage(WebDriver driver) {
		super(driver); //call the parent class constructor from the child class constructor
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}
	
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	
	public LoginPage goToLogInPage() {
		logger.info("Trying to perform click to go to Sign in page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

}
