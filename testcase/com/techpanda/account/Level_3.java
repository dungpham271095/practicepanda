package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
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

public class Level_3 extends BaseTest{
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
		userLoginPage = userHomePage.openLoginPage();
		
		userLoginPage.sendKeyToEmailTextbox("johnwick@gmail.com");
		userLoginPage.sendKeyToPassTextbox("123456");
		mydashboardPage = userLoginPage.clickToLogin();
		
		Assert.assertTrue(mydashboardPage.getContactInformation("johnwick@gmail.com"));

	}

	
	@Test
	public void TC_02() {
		mydashboardPage.openSideBarLinkByPageName("Account Information");
		accountInformationPage = PageGeneratorManagement.getAccountInformationPage(driver);
		
		accountInformationPage.openSideBarLinkByPageName("My Applications");
		myApplicationPage = PageGeneratorManagement.getMyApplicationPage(driver);
		
		myApplicationPage.openSideBarLinkByPageName("My Product Reviews");
		myProductReviewsPage = PageGeneratorManagement.getMyProductReviewsPagePage(driver);
	}



	
}
