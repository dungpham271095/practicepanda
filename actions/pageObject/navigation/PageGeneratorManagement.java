package pageObject.navigation;

import org.openqa.selenium.WebDriver;

import pageObject.admin.AdminManageCustomerPageObject;
import pageObject.user.AboutUsPageObject;
import pageObject.user.AccountInfomationPageObject;
import pageObject.user.MyAccountPageObject;
import pageObject.user.MyApplicationPageObject;
import pageObject.user.MyOrderPageObject;
import pageObject.user.MyProductReviewsPageObject;
import pageObject.user.MydashboardPageObject;
import pageObject.user.SearchTermPageObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.admin.AdminLoginPageObject;

public class PageGeneratorManagement {
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	public static AdminManageCustomerPageObject getAdminManageCutomerPage(WebDriver driver) {
		return new AdminManageCustomerPageObject(driver);
	}
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static MydashboardPageObject getMydashboardPagePage(WebDriver driver) {
		return new MydashboardPageObject(driver);
	}
	public static AccountInfomationPageObject getAccountInformationPage(WebDriver driver) {
		return new AccountInfomationPageObject(driver);
	}
	public static MyApplicationPageObject getMyApplicationPage(WebDriver driver) {
		return new MyApplicationPageObject(driver);
	}
	public static MyOrderPageObject getMyOrderPage(WebDriver driver) {
		return new MyOrderPageObject(driver);
	}
	public static MyProductReviewsPageObject getMyProductReviewsPagePage(WebDriver driver) {
		return new MyProductReviewsPageObject(driver);
	}
	public static AboutUsPageObject getAboutUsPage(WebDriver driver) {
		return new AboutUsPageObject(driver);
	}
	public static SearchTermPageObject getSearchTermPage(WebDriver driver) {
		return new SearchTermPageObject(driver);
	}
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
}
