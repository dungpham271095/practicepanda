package com.techpanda.account;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObject.navigation.PageGeneratorManagement;
import pageObject.navigation.SidebarMyAccountPageObject;
import pageObject.user.AboutUsPageObject;
import pageObject.user.AccountInfomationPageObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import reportConfig.ExtentManager;
import reportConfig.ExtentTestManager;
import pageObject.user.MyAccountPageObject;
import pageObject.user.MyApplicationPageObject;
import pageObject.user.MyOrderPageObject;
import pageObject.user.MyProductReviewsPageObject;
import pageObject.user.MydashboardPageObject;
import pageObject.user.SearchTermPageObject;

public class Level_10 extends BaseTest{
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
	public void TC_01(Method method ) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Login_invalid email and password");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: ckick to my account link");
		
		ExtentTestManager.getTest().log(Status.INFO,"Login_01 - step 01: Click to my account link");
		userLoginPage = userHomePage.openLoginPage();
		
		ExtentTestManager.getTest().log(Status.INFO,"Login_01 - step 02: enter to email address textbox with empty data");
		userLoginPage.sendKeyToEmailTextbox("");
		
		ExtentTestManager.getTest().log(Status.INFO,"Login_01 - step 03: enter to password textbox with empty data");
		userLoginPage.sendKeyToPassTextbox("");
		
		ExtentTestManager.getTest().log(Status.INFO,"Login_01 - step 04: click to login button");
		userLoginPage.clickToLogin();
		
		ExtentTestManager.getTest().log(Status.INFO,"Login_01 - step 05: verify error message is displayed");
		Assert.assertTrue(userLoginPage.getEmptyEmailErrorMessage("This is a required field."));
		Assert.assertTrue(userLoginPage.getEmptyPassErrorMessage("This is a required field."));
	}
	
	@Test
	public void TC_02(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Login_invalid email and password");
		ExtentTestManager.getTest().log(Status.INFO,"Login_02 - step 01: ");
		userLoginPage = userHomePage.openLoginPage();
		
		ExtentTestManager.getTest().log(Status.INFO,"Login_02 - step 02: ");
		userLoginPage.sendKeyToEmailTextbox("123@123");
		
		ExtentTestManager.getTest().log(Status.INFO,"Login_02 - step 03: ");
		userLoginPage.sendKeyToPassTextbox("123");
		
		ExtentTestManager.getTest().log(Status.INFO,"Login_02 - step 04: ");
		userLoginPage.clickToLogin();
		
		ExtentTestManager.getTest().log(Status.INFO,"Login_02 - step 05: ");
		Assert.assertTrue(userLoginPage.getInvalidEmailErrorMessage("Please enter a valid email address. For example johndoe@domain.com"));
		Assert.assertTrue(userLoginPage.getInvalidPassErrorMessage("Please enter 6 or more characters without leading or trailing spaces."));
	}
	@Test
	public void TC_03(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_03_Login_invalid email and password");
		ExtentTestManager.getTest().log(Status.INFO,"Login_03 - step 01: ");
		userLoginPage = userHomePage.openLoginPage();
		
		ExtentTestManager.getTest().log(Status.INFO,"Login_03 - step 02: ");
		userLoginPage.sendKeyToEmailTextbox("vietdung@gmail.com");
		
		ExtentTestManager.getTest().log(Status.INFO,"Login_03 - step 03: ");
		userLoginPage.sendKeyToPassTextbox("vietdung@gmail.com");
		
		ExtentTestManager.getTest().log(Status.INFO,"Login_03 - step 04: ");
		userLoginPage.clickToLogin();
		
		ExtentTestManager.getTest().log(Status.INFO,"Login_03 - step 05: ");
		Assert.assertTrue(userLoginPage.getInvalidAccountErrorMessage("Invalid login or password!"));

	}
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
//}
//		
		



	
}
