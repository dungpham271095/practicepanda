package com.jquery.dataTable;

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

public class Level_5_data_table extends BaseTest{
	
	WebDriver driver;
	HomePageObject homePage;
	@Parameters({"browser", "Url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {

		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01() {
		// nhap du lieu vao text box
		// parameter: header name: ten cot de enter
		// parameter: value nhap vao
//		homePage.enterToTextboxByHeaderName("Females", "384187");
//		homePage.sleepInSecond(3);
//		Assert.assertTrue(homePage.isRowValuesDisplayed("384187","Afghanistan","407124","791312"));
//		homePage.refreshToPage(driver);
//		
//		
//		homePage.enterToTextboxByHeaderName("Total", "24853148");
//		homePage.sleepInSecond(3);
//		Assert.assertTrue(homePage.isRowValuesDisplayed("12253515","AFRICA","12599691","24853148"));
//		homePage.refreshToPage(driver);
//		
//		
//		homePage.enterToTextboxByHeaderName("Country", "Angola");
//		homePage.sleepInSecond(3);
//		Assert.assertTrue(homePage.isRowValuesDisplayed("276880","Angola","276472","553353"));
//		homePage.refreshToPage(driver);
		
		// verify
		// click vao ten nuoc
//		homePage.clickToACtionIconByCountryName("Afghanistan","remove");
//		homePage.sleepInSecond(3);
//		
//		homePage.refreshToPage(driver);
//		
//		homePage.clickToACtionIconByCountryName("AFRICA","remove");
//		homePage.sleepInSecond(3);
//		
//		homePage.refreshToPage(driver);
//		
//		homePage.clickToACtionIconByCountryName("Argentina","edit");
//		homePage.sleepInSecond(3);
		
		// paging
		//click tung trang nor ra, page active
		homePage.clickToPageByNumber("10");
		
		Assert.assertTrue(homePage.isPageNumberActive("10"));
		// 
		
	}
	
	@AfterClass
	public void afterClass() {
//		driver.quit();
	}


	
}
