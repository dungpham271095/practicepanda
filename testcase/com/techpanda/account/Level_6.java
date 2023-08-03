package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObject.admin.AdminLoginPageObject;
import pageObject.admin.AdminManageCustomerPageObject;
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

public class Level_6 extends BaseTest{
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
	AdminLoginPageObject adminLoginPage;
	AdminManageCustomerPageObject adminManageCustomerPage;
	
	String userURL,adminURL;
	
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		this.userURL = GlobalConstants.LIVE_USER_URL;
		this.adminURL = GlobalConstants.LIVE_ADMIN_URL;
		driver = getBrowserDriver(browserName, userURL);
		userHomePage = PageGeneratorManagement.getUserHomePage(driver);
	}
	

	

	
	@Test
	public void TC_01() {
		userLoginPage = userHomePage.openLoginPage();
		
		userLoginPage.sendKeyToEmailTextbox("johnwick@gmail.com");
		userLoginPage.sendKeyToPassTextbox("123456");
		mydashboardPage = userLoginPage.clickToLogin();
		
		Assert.assertTrue(mydashboardPage.getContactInformation("johnwick@gmail.com"));
		
		// user -> admin -> khoi tao login admin
		
		 adminLoginPage = mydashboardPage.openAdminLoginPage(driver, adminURL);
		 
		 adminLoginPage.enterUserName("user01");
		 adminLoginPage.enterPass("guru99com");
		 
		 adminManageCustomerPage = adminLoginPage.clickToLoginButton();
		 adminManageCustomerPage.closeIncomingMessagePopup();
		// logout
		 adminLoginPage = adminManageCustomerPage.clickToLogOut(driver);
		// admin -> user
		 userHomePage = adminLoginPage.openUserHomePage(driver, userURL);
	}



	
}
