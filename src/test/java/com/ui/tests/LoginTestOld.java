package com.ui.tests;
import com.ui.pages.HomePage;
import com.utility.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class LoginTestOld {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver(); //Will launch a Browser Window!! Browser Session is created
		HomePage homePage = new HomePage(wd);
		homePage.goToWebsite("http://www.automationpractice.pl/index.php");
		homePage.maximizeWindow();
		
		By signInLinkLocator = By.xpath("//a[contains(text(),'Sign in')]");
		homePage.clickOn(signInLinkLocator);
		
		By emailTextBoxLocator = By.id("email");
		homePage.enterText(emailTextBoxLocator, "asdfghjk");
		
		By passwordTextBoxLocator = By.id("passwd");
		homePage.enterText(passwordTextBoxLocator, "asdfghjk");
		
		By submitLoginLocator = By.id("SubmitLogin");
		homePage.clickOn(submitLoginLocator);
	}

}
