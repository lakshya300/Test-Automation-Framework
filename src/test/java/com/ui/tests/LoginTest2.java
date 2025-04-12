package com.ui.tests;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utility.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class LoginTest2 {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver(); //Will launch a Browser Window!! Browser Session is created
		HomePage homePage = new HomePage(wd);
		homePage.goToLogInPage().doLoginWith("", "");
		
	}

}
