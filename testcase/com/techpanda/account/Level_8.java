package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.navigation.PageGeneratorManagement;
import pageObject.navigation.SidebarMyAccountPageObject;
import pageObject.user.AboutUsPageObject;
import pageObject.user.AccountInfomationPageObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.MyAccountPageObject;
import pageObject.user.MyApplicationPageObject;
import pageObject.user.MyOrderPageObject;
import pageObject.user.MyProductReviewsPageObject;
import pageObject.user.MydashboardPageObject;
import pageObject.user.SearchTermPageObject;

public class Level_8 extends BaseTest{
	WebDriver driver;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	MydashboardPageObject mydashboardPage;
	AccountInfomationPageObject accountInformationPage;
	MyApplicationPageObject myApplicationPage;
	MyOrderPageObject myOrderPage;
	MyProductReviewsPageObject myProductReviewsPage;
	SidebarMyAccountPageObject sidebarPage;
	AboutUsPageObject aboutUsPage;
	SearchTermPageObject searchTermPage;
	MyAccountPageObject myAccountPage;
	
	String userURL,adminURL;
	
	@Parameters({"browser", "userURL", "adminURL"})
	@BeforeClass
	public void beforeClass(String browserName, String userURL, String adminURL) {
		this.userURL = userURL;
		this.adminURL = adminURL;
		driver = getBrowserDriver(browserName, userURL);
		userHomePage = PageGeneratorManagement.getUserHomePage(driver);
	}
	
	@Test
	public void TC_01() {
		
		log.info("Login_01 - step 01: Click to my account link");
		userLoginPage = userHomePage.openLoginPage();
		
		log.info("Login_01 - step 02: enter to email address textbox with empty data");
		userLoginPage.sendKeyToEmailTextbox("");
		
		log.info("Login_01 - step 03: enter to password textbox with empty data");
		userLoginPage.sendKeyToPassTextbox("");
		
		log.info("Login_01 - step 04: click to login button");
		userLoginPage.clickToLogin();
		
		log.info("Login_01 - step 05: verify error message is displayed");
		Assert.assertTrue(userLoginPage.getEmptyEmailErrorMessage("This is a required field."));
		Assert.assertTrue(userLoginPage.getEmptyPassErrorMessage("This is a required field."));
	}
	
	@Test
	public void TC_02() {
		log.info("Login_02 - step 01: ");
		userLoginPage = userHomePage.openLoginPage();
		
		userLoginPage.sendKeyToEmailTextbox("123@123");
		userLoginPage.sendKeyToPassTextbox("123");
		userLoginPage.clickToLogin();
		
		Assert.assertTrue(userLoginPage.getInvalidEmailErrorMessage("Please enter a valid email address. For example johndoe@domain.com"));
		Assert.assertTrue(userLoginPage.getInvalidPassErrorMessage("Please enter 6 or more characters without leading or trailing spaces."));
	}
//	@Test
//	public void TC_03() {
//		userLoginPage = userHomePage.openLoginPage();
//		
//		userLoginPage.sendKeyToEmailTextbox("vietdung@gmail.com");
//		userLoginPage.sendKeyToPassTextbox("vietdung@gmail.com");
//		userLoginPage.clickToLogin();
//		
//		Assert.assertTrue(userLoginPage.getInvalidAccountErrorMessage("Invalid login or password."));
//
//	}
//	
//	@Test
//	public void TC_04() {
//		userLoginPage = userHomePage.openLoginPage();
//		
//		userLoginPage.sendKeyToEmailTextbox("johnwick@gmail.com");
//		userLoginPage.sendKeyToPassTextbox("123456");
//		mydashboardPage = userLoginPage.clickToLogin();
//		
//		Assert.assertTrue(mydashboardPage.getContactInformation("johnwick@gmail.com"));
//
//	}
//	@Test
//	public void TC_05_Update_Account() {
//		accountInformationPage = mydashboardPage.openAccountInformationPage();
//		
//		accountInformationPage.sendKeyToFirstName("pham");
//		accountInformationPage.sendKeyToMiddleName("do viet");
//		accountInformationPage.sendKeyToLastName("dung");
//		accountInformationPage.sendKeyToCurrentPass("123456");
//		mydashboardPage = accountInformationPage.clickSaveButton();
//		
//		Assert.assertTrue(mydashboardPage.getUpdateInformation("The account information has been saved."));
//		
//		
//


	
}
