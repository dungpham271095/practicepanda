package com.jquery.upload;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObject.admin.AdminLoginPageObject;
import pageObject.admin.AdminManageCustomerPageObject;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManager;
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

public class Level_6_uploadFile extends BaseTest{
	
	WebDriver driver;
	HomePageObject homePage;
	@Parameters({"browser", "Url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {

		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		
	}

	@Test
	public void TC_01_One_File() {
		homePage.uploadMultipleFiles(driver, ocIMG);
		Assert.assertTrue(homePage.isLoadSuccess(ocIMG));
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileUpload(ocIMG));
	}
	@Test
	public void TC_02_Multiple_file() {
		homePage.refreshToPage(driver);
		homePage.uploadMultipleFiles(driver, ocIMG,twoIMG,keyIMG );
		Assert.assertTrue(homePage.isLoadSuccess(ocIMG));
		Assert.assertTrue(homePage.isLoadSuccess(twoIMG));
		Assert.assertTrue(homePage.isLoadSuccess(keyIMG));
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileUpload(ocIMG));
		Assert.assertTrue(homePage.isFileUpload(twoIMG));
		Assert.assertTrue(homePage.isFileUpload(keyIMG));
	}
	
	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

	String ocIMG = "oc.png";
	String twoIMG = "2.png";
	String keyIMG = "phimtat.jpg";
	
}
