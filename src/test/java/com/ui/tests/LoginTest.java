package com.ui.tests;
import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({com.ui.listners.TestListner.class})
public class LoginTest extends TestBase{
	
	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Test(description = "Verifies if the valid user is able to login into the application", groups = {"e2e","sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider",
			retryAnalyzer = com.ui.listners.MyRetryAnalyzer.class)
	public static void loginTest(User user) {
		
		assertEquals(homePage.goToLogInPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Lakshya Agrawal");
	}
	/*@Test(description = "Verifies if the valid user is able to login into the application", groups = {"e2e","sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
	public static void loginCSVTest(User user) {
		
		assertEquals(homePage.goToLogInPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Lakshya Agrawal");
	}
	@Test(description = "Verifies if the valid user is able to login into the application", groups = {"e2e","sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider")
	public static void loginExcelTest(User user) {
		assertEquals(homePage.goToLogInPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Lakshya Agrawal");
	}*/
	
}
